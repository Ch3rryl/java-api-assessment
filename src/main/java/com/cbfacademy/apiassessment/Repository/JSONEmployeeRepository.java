package com.cbfacademy.apiassessment.Repository;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.Model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@Repository
@Primary
public class JSONEmployeeRepository implements EmployeeRepository {
    private final String filePath;
    private final Gson gson;
    private final Map<UUID, Employee> database;

        public ListEmployeeRepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .create();
        database = loadDataFromJson();
    }

        class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
        @Override
        public JsonElement serialize(Instant instant, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(instant.toString());
        }

        @Override
        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return Instant.parse(json.getAsString());
        }
    } 

}


//     private Map<UUID, IOU> loadDataFromJson() {
//         try (Reader reader = new FileReader(filePath)) {
//             Type type = new TypeToken<Map<UUID, IOU>>() {
//             }.getType();

//             return gson.fromJson(reader, type);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return new HashMap<>();
//     }

//     private void saveDataToJson() {
//         try (Writer writer = new FileWriter(filePath)) {
//             gson.toJson(database, writer);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public Iterable<IOU> findAll() {
//         return database.values();
//     }

//     @Override
//     public Optional<IOU> findById(UUID id) {
//         return Optional.ofNullable(database.get(id));
//     }

//     @Override
//     public <S extends IOU> S save(S entity) {
//         database.put(entity.getId(), entity);
//         saveDataToJson();

//         return entity;
//     }

//     @Override
//     public void deleteById(UUID id) {
//         database.remove(id);
//         saveDataToJson();
//     }

//     @Override
//     public List<IOU> searchByBorrower(String name) {
//         return database.values().stream()
//                 .filter(iou -> iou.getBorrower().equals(name))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public List<IOU> searchByLender(String name) {
//         return database.values().stream()
//                 .filter(iou -> iou.getLender().equals(name))
//                 .collect(Collectors.toList());
//     }
// }