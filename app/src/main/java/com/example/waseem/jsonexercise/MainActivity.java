package com.example.waseem.jsonexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MainActivity extends AppCompatActivity {

    private JSONArray colours;

 


    private  String content;

    private JSONObject codeJsonOBJ;
    private String color;
    private String[] array;
    private int Counter=0;
    private TextView text;
    private  String textToPrint="";
    private JSONObject obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        content = " [\n" +
                "  {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 255, 1], \n " +
                "   \"hex\": \"#000\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"white\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 0, 1], \n " +
                "   \"hex\": \"#FFF\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"red\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 0, 0, 1], \n " +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"blue\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 255, 1], \n" +
                "   \"hex\": \"#00F\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"yellow\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 0, 1], \n" +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"green\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"secondary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 255, 0, 1], \n" +
                "   \"hex\": \"#0F0\" \n" +
                "   }\n" +
                "   } \n" +
                "  ] ";
        }

        public void modify(View view ) throws JSONException {

             text = findViewById(R.id.textView);

            try {
                 colours = (JSONArray) new JSONTokener(content).nextValue();

                JSONObject orange = new JSONObject();
                orange.put("color", "orange");
                orange.put("category", "hue");
                orange.put("tyep", "primary");

                JSONObject code1 = new JSONObject();

                code1.put("rgba", new JSONArray("[255, 165, 0, 1]") );
                code1.put("hex", " #FA0");
                orange.put("code", code1);

                colours.put(orange);
                    text.setText(colours.toString(2));

            }catch(Exception e ){
                throw new NullPointerException();
            }

        }

        public void match (){
            try {
                colours = (JSONArray) new JSONTokener(content).nextValue();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            text = findViewById(R.id.textView);
            for (int i =0; i< colours.length(); i++){
                try {
                    obj = (JSONObject) colours.get(i);
                    codeJsonOBJ = (JSONObject) obj.get("code");
                    color= codeJsonOBJ.get("rgba").toString();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                array = color.split(",");
                if(array[1].equals("255")){
                    try {
                        textToPrint +=(String)obj.get("color")+"\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Counter++;
                }
            }


        }

        public void count(View view){
            match();
            text.setText(String.valueOf(Counter));
            Counter = 0 ;
            textToPrint="";
        }

        public void list(View view){
            text= findViewById(R.id.textView);
            match();

            text.setText(textToPrint);
           textToPrint="";
            Counter=0;

            }

        }








