package HW3;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class StockManagerSingleton {
	
	private static String inventoryFilePath = "src/data/inventory.csv";
	ArrayList<MediaProduct> Inventory = new ArrayList<>();
	
	public boolean initializeStock() {
		ArrayList<String> unformattedData = new ArrayList<>();
		try {
			File data = new File(inventoryFilePath);
			Scanner dataScanner = new Scanner(data); 
			while (dataScanner.hasNextLine()) {
				String line = dataScanner.nextLine();
				unformattedData.add(line);
			}
			dataScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return false;
		}
		
		for (String line : unformattedData) {
			System.out.println(line);
		}
		
		for (String dataLine : unformattedData) {
			String[] brokenData = dataLine.split(",");
			System.out.println(Arrays.toString(brokenData));
			if ("CD".equals(brokenData[0])) {
				CDRecordProduct cd = new CDRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(cd);
			} else if ("Vinyl".equals(brokenData[0])){
				VinylRecordProduct v = new VinylRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(v);
			} else if ("Tape".equals(brokenData[0])) {
				TapeRecordProduct t = new TapeRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(t);
			}
		}
		
		return true;
	}
	
	public boolean saveStock() {
		try {
			// open the file with a FileWriter object
			FileWriter dataWriter = new FileWriter(inventoryFilePath);
			
			//iterate through each Inventory product
			for (MediaProduct unsavedProduct : Inventory) {
				String productType; //save this string depending on object type
				if (unsavedProduct instanceof CDRecordProduct) {
					productType = "CD";
				}
				else if (unsavedProduct instanceof VinylRecordProduct) {
					productType = "Vinyl";
				}
				else {
					productType = "Tape";
				}
				
				// get all attributes of the object 
				String title = unsavedProduct.title;
				double price = unsavedProduct.price;
				int year = unsavedProduct.year;
				Genre genre = unsavedProduct.genre;
				
				//create a string in the correct format and write it to the file
				String line = productType + "," + title + "," + price + "," + year + "," + genre + "\n";
				dataWriter.write(line);
			}
			dataWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace(); 
			return false;
		}
		
		return true; //return true for success !!
	}
	
	public static void main(String[] args) {
		StockManagerSingleton stockManager = new StockManagerSingleton();
		stockManager.initializeStock();
		System.out.println("Finished initialization!\n\n\n");
		stockManager.saveStock();
		stockManager.initializeStock();
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		for (MediaProduct p : Inventory) {
			if (p.title.equals(product.title)) {
				p.price = newPrice;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeItem(MediaProduct product) {
		for (MediaProduct p : Inventory) {
			if (p.title.equals(product.title)) {
				Inventory.remove(Inventory.indexOf(p));
			}
		}
		return true;
	}
	
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
	}
	
	public ArrayList<VinylRecordProduct> 
	getVinylRecordList(ArrayList<MediaProduct> productList) {
		
	}
	
	public ArrayList<CDRecordProduct> 
	getCDRecordList(ArrayList<MediaProduct> productList) {
		
	}
	public ArrayList<TapeRecordProduct> 
	getTapeRecordList(ArrayList<MediaProduct> productList) {
		
	}
}
