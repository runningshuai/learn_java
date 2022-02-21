package learnGson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class test2 {

//    @SerializedName(value="name", alternate = {"Name", "NAME"})
//    private String studentName;

    public static void main(String[] args){
        //序列化
        Gson gson = new Gson();
        User user = new User("紫萱", 12, 78.0);
        String jsonObject = gson.toJson(user);
        System.out.println(jsonObject);
        //解析
        Gson gson2 = new Gson();
        String jsonString = "{\"Name\":\"紫萱\",\"age\":12,\"score\":78.0}";
        User user2 = gson2.fromJson(jsonString, User.class);
        System.out.println(user2.name + "," + user2.getAge() + "," + user2.getScore());

        //




    }
}
