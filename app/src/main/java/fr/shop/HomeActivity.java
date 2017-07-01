package fr.shop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        RelativeLayout root = (RelativeLayout) findViewById(R.id.root_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maxresdefault);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        root.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        Button btn = (Button) findViewById(R.id.signin_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String REST_SERVICE_URL = "http://localhost:5333/RestService/rest/Custumer/add";
                try{
                    Client client = Client.create();
                    WebResource webRessource = client.resource(REST_SERVICE_URL);
                    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
                    formData.add("name", "Guardiola");
                    formData.add("email", "guardiola@gmail.com");
                    formData.add("adress", "Manchester");
                    ClientResponse response = webRessource.type("application/x-www-form-urlencoded").post(ClientResponse.class, formData);

                    if(response.getStatus() != 200){
                        throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
                    }
                    String output = response.getEntity(String.class);
                    System.out.println("Output from Server .... \n");
                    System.out.println(output);
                    ((Button)v).setText(output);
                }catch(Exception e){
                    System.out.println("ERROR TYPE: " + e.getClass());
                    e.printStackTrace();
                }
            }
        });

    }
}
