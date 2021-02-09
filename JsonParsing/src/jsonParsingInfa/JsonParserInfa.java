package jsonParsingInfa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParserInfa {
	
	private void JsonParser()
	{
		String filepath = "C:/Users/RITESH/Desktop/Temp2/FilesAndZip/SampleDataInfa.json";
		
		
		try {
			File fileTgt = new File("C:/Users/RITESH/Desktop/Temp2/FilesAndZip/SampleDataInfaParsed.txt");
			Object obj = new JSONParser().parse(new FileReader(filepath));
			StringBuilder builder =new StringBuilder();
			BufferedWriter writer = null;
			JSONArray jo = (JSONArray) obj;
			
			for(int i = 0; i < jo.size(); i++)

			{

			JSONObject objects = (JSONObject)jo.get(i);

			Long userId = (Long) objects.get("userId");
			String firstName = (String) objects.get("firstName");
			String lastName = (String) objects.get("lastName");
			String phoneNumber = (String) objects.get("phoneNumber");
			String emailAddress = (String) objects.get("emailAddress");

			builder.append(userId);
			builder.append("|");
			builder.append(firstName);
			builder.append("|");
			builder.append(lastName);
			builder.append("|");
			builder.append(phoneNumber);
			builder.append("|");
			builder.append(emailAddress);
			builder.append("\n");
			
			try 
			{
				writer = new BufferedWriter(new FileWriter(fileTgt));
				writer.write(builder.toString());
			}finally 
			{
				if(writer != null)writer.close();
			}

			}

			    }

			catch (Exception e) {

			e.printStackTrace();

			}
	}

	public static void main(String[] args) 
	{
		JsonParserInfa obj = new JsonParserInfa();
		obj.JsonParser();
	    System.out.println("Values assigned");

	}

}
