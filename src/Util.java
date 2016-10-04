import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
	import java.util.TimeZone;

/**
	 * 
	 * @author msimiste
	 * This Class was created in order to assist with the I/O involved in CPSC418 Assignment1
	 * Additionally, some date conversion utilities were required and added to this class
	 * @version 1.0 Sept 21, 2016
	 */
public class Util {	

		private String catalogFilePath = "A1_Ciphertext.txt";
		private File catalogFile = new File(catalogFilePath);

		public Util() {}

		/**
		 * 
		 * @return  A hashmap which The relative frequencies of the letters {A...Z} contained in a ciphertext
		 */
		public Map<Character, Integer> getSingleLetterCountFromFile() {

			FileReader fr = null;
			Map<Character, Integer> catalog = new HashMap<Character, Integer>();

			try {
				fr = new FileReader(catalogFile.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			Scanner in = new Scanner(br);

			// while (catalog.put(in.next(), convertToDate(in.next())) != null);
			String lines = "";

			
			while (in.hasNextLine()) {
				lines += in.nextLine();
				
			}
			
			for(int i = 0; i<lines.length(); i++)
			{
				if(catalog.containsKey(lines.charAt(i))){
					catalog.put(lines.charAt(i), catalog.get(lines.charAt(i))+1);
				}
				else{
					catalog.put(lines.charAt(i), 1);
				}
			}

			in.close();
			return catalog;
		}
		
		public Map<String,Integer> getGraphs(int index){
			FileReader fr = null;
			Map<String, Integer> catalog = new HashMap<String, Integer>();

			try {
				fr = new FileReader(catalogFile.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			Scanner in = new Scanner(br);

			// while (catalog.put(in.next(), convertToDate(in.next())) != null);
			String lines = "";

			
			while (in.hasNextLine()) {
				lines += in.nextLine();
				
			}
			
			for(int i = 0; i<lines.length()-(index-1); i++)
			{
				String temp = lines.substring(i, i+index);
				if((temp.length()== 1)||(temp.contains(" "))){}
				else if(catalog.containsKey(temp)){
					catalog.put(temp, catalog.get(temp)+1);
				}
				else{
					catalog.put(temp, 1);
				}
			}

			in.close();
			return catalog;
		}
		
		public String deCrypt(){
			
			FileReader fr = null;
			Map<Character, Integer> catalog = new HashMap<Character, Integer>();

			try {
				fr = new FileReader(catalogFile.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			Scanner in = new Scanner(br);

			// while (catalog.put(in.next(), convertToDate(in.next())) != null);
			String lines = "";
			String out = "";

			
			while (in.hasNextLine()) {
				lines += in.nextLine();				
			}
			
			for(int i = 0; i<lines.length(); i++){
				char temp = lines.charAt(i);
				if(temp=='X'){
					out +="e";
				}
				else if(temp=='O'){
					out+="t";
				}
				else if(temp=='I'){
					out+="h";
				}
				else if(temp=='R'){
					out+="a";
				}				
				else if(temp=='T'){
					out+="n";
				}
				else if(temp=='J'){
					out+="o";
				}
				else if(temp=='S'){
					out+="f";
				}
				else if(temp=='L'){
					out+="b";
				}
				else if (temp=='Z'){
					out+="y";
				}
				else if(temp=='E'){
					out+="w";
				}
				else if(temp=='C'){
					out+="r";
				}
				else if(temp=='D'){
					out+="u";
				}
				
				else if(temp=='U'){
					out+="s";
				}
				else if(temp=='A'){
					out+="d";
				}
				else if(temp=='F'){
					out+="c";
				}
				else if(temp=='K'){
					out+="l";
				}
				else if(temp=='N'){
					out+="m";
				}
				else if(temp=='P'){
					out+="i";
				}
				else if(temp=='G'){
					out+="g";
				}
				else if(temp=='Q'){
					out+="p";
				}
				else if(temp=='Y'){
					out+="q";
				}
				else if(temp=='M'){
					out+="v";
				}
				else if(temp=='V'){
					out+="k";
				}
				else if(temp=='B'){
					out+="t";
				}
				else if(temp=='H'){
					out+="x";
				}
				else if (temp=='W'){
					out+="z";
				}
				
				
				
				
				
				/*
				else if (temp=='J'){
					out+='o';
				}	
				else if (temp=='N'){
					out+='o';
				}
				else if(temp=='A'){
					out+='d';
				}
				else if(temp=='C'){
					out+='s';
				}
				else if(temp=='U'){
					out+='r';
				}
				else if(temp=='T')
				{
					out+='d';
				}*/
				
			/*	else if(temp=='T'){
					out+='i';
				}
				
				else if(temp=='A'){
					out+='r';
				}
				else if(temp=='F'){
					out+='i';
				}
				else if(temp=='C'){
					out+='s';
				}
				else if(temp=='N'){
					out+='u';
				}*/
				else
				{
					out+=temp;
				}
			}
			
			return out;
		}

		/**
		 * 
		 * @param catalog - A hashmap, the contents of which are stored in a file locally
		 */
		public void writeCatalogToFile(Map<String, Long> catalog) {

			FileWriter fw = null;
			PrintWriter pw = null;

			try {
				if (!(catalogFile.exists())) {
					catalogFile.createNewFile();
				}
				fw = new FileWriter(catalogFile.getAbsolutePath());
				pw = new PrintWriter(fw, true);

				for (Map.Entry<String, Long> i : catalog.entrySet()) {
					pw.println(i);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pw.close();
			}
		}

		/**
		 * 
		 * @return A boolean value indicating if there is a catalog file stored
		 *         locally or not, ie if there is a local file it returns true,
		 *         otherwise it returns false
		 */
		public boolean checkLocalCache() {
			return catalogFile.exists();
		}
		
		

		/**
		 * 
		 * @param in - A date in the form of a String
		 * @return Date value which has been formatted
		 */
		public Date convertToDate(String in) {
			Date date = null;
			DateFormat d = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
			d.setTimeZone(TimeZone.getTimeZone("GMT"));
			try {
				date = d.parse(in);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return date;
		}

		/**
		 * 
		 * @param lastModDate
		 *            A Time to be formatted
		 * @return Date value which has been formatted
		 */
		public Date convertToDate(long lastModDate) {
			Date date = null;
			DateFormat d = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
			d.setTimeZone(TimeZone.getTimeZone("GMT"));

			try {
				date = d.parse(d.format(lastModDate));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			return date;
		}

		/**
		 * 
		 * @param lastMod
		 *            A Time value to be formatted
		 * @return String which has been converted to a date and formatted.
		 */
		public String convertDateToString(long lastMod) {

			DateFormat d = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
			d.setTimeZone(TimeZone.getTimeZone("GMT"));
			String date = d.format(lastMod);

			return date;
		}
	}


