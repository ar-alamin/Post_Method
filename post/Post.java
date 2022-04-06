package post;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Post {

    public static void main(String[] args)throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "Application/json;utf-8");
        
        connection.setDoOutput(true);
        String Post_data = "{User-ID: 10, ID:101}";
        OutputStream output = connection.getOutputStream();
        output.write(Post_data.getBytes());
        output.flush();
        output.close();

        int response = connection.getResponseCode();
        System.out.println("Response " + response);
        System.out.println("Response Message " + connection.getResponseMessage());
    
        
        if (response == HttpURLConnection.HTTP_CREATED) {
        	
        	BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));//read
        	StringBuffer str = new StringBuffer();
        	String line = null;
        
        while ((line = read.readLine()) != null) {
            str.append(line);
        } read.close();
        
        System.out.println("POST Response " + str.toString());
        }       
    }    
}
