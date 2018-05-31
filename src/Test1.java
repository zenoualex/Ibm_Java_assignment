
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alexa
 */
/**
 * You are given a file input.json which is passed as the 1st argument at the
 * execution of the program. It contains a json string representing a tree
 * structure of objects with attributes: "activityID","status", "subActivities".
 * The subActivities is a table that can contain the same type of objects. In
 * this structure we need to go through all the elements and change the status
 * to "completed" but there are restrictions. An activity cannot be "completed"
 * before all of its subActivities are completed. Your task is to write (a)
 * function(s) that goes through this structure and "completes" the activities
 * in the correct order.
 *
 * For documentation about how to handle Json objects, refer to google.gson
 * package.
 */
public class Test1 {

    public Test1() {
    }

    /**
     * The function where the main logic of your program is located. It has the
     * following steps: 1. Reads the input file and converts it to a String. 2.
     * Converts the string to JsonArray 3. Calls the function that runs through
     * the tree and closes the activities
     *
     * @param path
     */
    public void execute(String path) {
        try {

            String json = FileUtils.readFileToString(new File(path));
            JsonArray tree = new JsonParser().parse(json).getAsJsonArray();
            closeActivities(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Place your code here along with some comments if possible, to understand
     * your thought process.
     *
     * @param input
     */
    private void closeActivities(JsonArray input) {

        for (int j = 0; j < input.size(); j++) {
            JsonObject jsonObject1 = (JsonObject) input.get(j);
            JsonArray jsonarray1 = (JsonArray) jsonObject1.get("subActivities");
            for (int i = 0; i < jsonarray1.size(); i++) {
                JsonObject jsonObject2 = (JsonObject) input.get(i);
                System.out.println(((JsonObject) jsonarray1.get(i)).get("subActivities").toString());
                if (jsonObject2.get("status").toString().equals("status")){
                    jsonObject2.remove("status");
                }
            }
        }
    }

    /**
     * You don't need to do anything here, just call this function when you are
     * ready to change the status to "completed" It will just print that you are
     * closing it, you don't have to actually change the values of the objects.
     *
     * @param activity
     */
    private void closeActivity(JsonObject activity) {
        System.out.println("closing activity " + activity.get("activityID"));
    }
}
