package com.example.pack_easy.Data;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.pack_easy.Constants.MyConstants;
import com.example.pack_easy.Models.Items;

import com.example.pack_easy.Database.RoomDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB database;
    String category;
    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 1;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;
        this.context = context;
    }

    public List<Items> getBasicData(){
        category = "Basic Needs";
        List<Items> basicItem = new ArrayList<>();
        basicItem.add(new Items("Passport", category, false));
        basicItem.add(new Items("Visa", category, false));
        basicItem.add(new Items("Money", category, false));
        basicItem.add(new Items("Travel Itinerary", category, false));
        basicItem.add(new Items("Travel Tickets", category, false));
        basicItem.add(new Items("Hotel Reservations", category, false));
        basicItem.add(new Items("Identification Documents", category, false));
        basicItem.add(new Items("Medications", category, false));
        basicItem.add(new Items("Emergency Contacts", category, false));
        basicItem.add(new Items("Travel Insurance", category, false));
        basicItem.add(new Items("Maps", category, false));
        basicItem.add(new Items("Chargers and Power Banks", category, false));
        basicItem.add(new Items("Travel Pillow and Blanket", category, false));
        basicItem.add(new Items("Reusable Water Bottle", category, false));
        basicItem.add(new Items("Snacks", category, false));
        return basicItem;
    }


    public List<Items> getPersonalCareData(){
        String[] data = {
                "Toothbrush",
                "Toothpaste",
                "Shampoo",
                "Conditioner",
                "Soap",
                "Body Wash",
                "Deodorant",
                "Comb",
                "Razor",
                "Shaving Cream",
                "Face Wash",
                "Moisturizer",
                "Sunscreen",
                "Lip Balm",
                "Contact Lenses",
                "Glasses",
                "Contact Lens Solution and Case",
                "Feminine Hygiene Products",
                "Nail Clippers",
                "Towel or Travel Towel",
                "Hair ties or Hairpins",
                "Cotton Swabs",
                "Prescription Medications",
                "First Aid Kit",
                "Hand Sanitizer",
                "Wet Wipes"
        };
        return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE, data);
    }


    public List<Items> getClothingData() {
        String[] data = {
                "T-shirts",
                "Pants",
                "Shorts",
                "Underwear",
                "Socks",
                "Pajamas",
                "Sleepwear",
                "Swimsuit",
                "Sweater",
                "Jacket",
                "Skirts",
                "Belt",
                "Hat/Cap",
                "Sunglasses",
                "Raincoat/Poncho",
                "Comfortable Shoes",
                "Sandals/Flip-flops",
                "Formal Attire",
                "Gloves",
                "Scarf",
                "Beanie or Winter Hat",
                "Long-sleeve Shirts",
                "Dress Shoes",
                "Hiking/Outdoor Clothing",
                "Athletic Shoes",
                "Running or Workout Clothes",
                "Tie or Bowtie (if needed)",
                "Tights or Leggings",
                "Swim Cover-up",
                "Hoodie or Sweatshirt",
                "Dress Socks",
                "Thermal Underwear (for cold weather)",
                "Tie or Bowtie (if needed)",
                "Dress Socks",
                "Thermal Underwear (for cold weather)",
                "Suit (for formal events)",
                "Tuxedo (for very formal events)",
                "Costume (if applicable, e.g., for themed parties)",
                "Accessories (jewelry, watches, etc.)"
        };
        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE, data);
    }



    public List<Items> getBabyNeedData() {
        String[] data = {
                "Diapers",
                "Baby Wipes",
                "Baby Food",
                "Bottles and Formula",
                "Baby Clothes",
                "Baby Blankets",
                "Pacifiers",
                "Baby Toys",
                "Baby Carrier or Stroller",
                "Changing Mat",
                "Baby Bathing Essentials",
                "Baby Sunscreen",
                "Baby Medicine and First Aid Kit",
                "Baby Documents",
                "Baby Car Seat",
                "Baby Monitor"
        };
        return prepareItemsList(MyConstants.BABY_NEEDS_CAMEL_CASE, data);
    }


    public List<Items> getHealthData() {
        String[] data = {
                "Prescription Medications",
                "First Aid Kit",
                "Pain Relievers",
                "Allergy Medications",
                "Antacids",
                "Motion Sickness Medication",
                "Hand Sanitizer",
                "Insect Repellent",
                "Sunscreen",
                "Personal Hygiene Items",
                "Health Insurance Cards",
                "Emergency Contact Information",
                "Medical Records",
                "Face Masks"
        };
        return prepareItemsList(MyConstants.HEALTH_CAMEL_CASE, data);
    }


    public List<Items> getTechnologyData() {
        String[] data = {
                "Smartphone and Charger",
                "Laptop and Charger",
                "Tablet and Charger",
                "Power Bank/Portable Charger",
                "Travel Adapter",
                "Headphones/Earphones",
                "Camera and Accessories",
                "Memory Cards/Storage",
                "Travel Router",
                "Cables and Charging Accessories",
                "Portable Wi-Fi Hotspot",
                "External Hard Drive/Backup Storage",
                "E-book Reader",
                "Travel Apps (e.g., Maps, Translation, Weather)",
                "USB Drive",
                "Gadget Cleaning Kit",
                "Bluetooth Speaker"
        };
        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE, data);
    }


    public List<Items> getFoodNeedData() {
        String[] data = {
                "Snacks (e.g., granola bars, nuts, trail mix)",
                "Bottled Water or Reusable Water Bottle",
                "Fruit (e.g., apples, bananas)",
                "Sandwiches or Wraps",
                "Dried Fruits",
                "Instant Noodles or Soup Cups",
                "Canned Food (e.g., tuna, beans)",
                "Utensils (fork, knife, spoon)",
                "Reusable Food Containers",
                "Thermos for Hot Beverages",
                "Condiments (e.g., ketchup, mayo)",
                "Disposable Plates and Napkins",
                "Travel Coffee Mug",
                "Travel Cutlery Set",
                "Tea Bags or Instant Coffee",
                "Emergency Snacks"
        };
        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE, data);
    }


    public List<Items> getBeachNeedData() {
        String[] data = {
                "Swimsuit",
                "Beach Towel or Mat",
                "Sunscreen",
                "Beach Umbrella or Shade Tent",
                "Beach Chairs or Loungers",
                "Beach Bag or Tote",
                "Sunglasses",
                "Hat or Cap",
                "Flip-flops or Sandals",
                "Waterproof Phone Case or Pouch",
                "Snorkel and Mask",
                "Beach Toys",
                "Cooler with Drinks and Snacks",
                "Water Bottles",
                "Trash Bags",
                "Bluetooth Speaker"
        };
        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE, data);
    }


    public List<Items> getCarNeedData() {
        String[] data = {
                "Driver's License and Vehicle Registration",
                "Proof of Insurance",
                "Road Map or GPS Device",
                "Spare Tire and Jack",
                "Car Manual",
                "Jumper Cables",
                "Basic Toolkit (screwdriver, pliers, wrench)",
                "Tire Pressure Gauge",
                "First Aid Kit",
                "Emergency Flares or Reflective Triangles",
                "Flashlight and Batteries",
                "Blanket or Sleeping Bag",
                "Water and Non-Perishable Snacks",
                "Trash Bags",
                "Car Charger for Electronics",
                "Hand Sanitizer and Wet Wipes",
                "Travel Pillow and Blanket",
                "Entertainment (e.g., books, music)",
                "Sunglasses and Sunscreen",
                "Paper Towels and Tissues",
                "Extra Clothing and Rain Gear",
                "Cash and Coins for Tolls",
                "Mobile Phone and Charger",
                "Emergency Contact Information",
                "Snacks for Kids (if traveling with children)",
                "Spare Car Key",
                "Travel and Accommodation Documents",
                "Prescription Medications",
                "Personal Hygiene Items (toothbrush, toothpaste, etc.)",
                "Spare Fluids (motor oil, coolant, washer fluid)",
                "Fire Extinguisher",
                "Spare Fuses",
                "Multi-Tool or Swiss Army Knife",
                "Car Organizer or Storage Solutions",
                "Child Safety Equipment (car seats, entertainment)",
                "Specialized Gear (hiking, biking, water sports, etc.)"
        };
        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE, data);
    }


    public List<Items> prepareItemsList(String category, String[] data) {
        List<String> list = Arrays.asList(data);
        List<Items>dataList = new ArrayList<>();
        dataList.clear();

        for (int i = 0; i< list.size(); i++){
            dataList.add(new Items(list.get(i),category,false));
        }
        return dataList;
    }

    public List<List<Items>> getAllData(){
        List<List<Items>> listofAllItems = new ArrayList<>();
        listofAllItems.clear();
        listofAllItems.add(getBasicData());
        listofAllItems.add(getClothingData());
        listofAllItems.add(getPersonalCareData());
        listofAllItems.add(getBabyNeedData());
        listofAllItems.add(getHealthData());
        listofAllItems.add(getTechnologyData());
        listofAllItems.add(getFoodNeedData());
        listofAllItems.add(getBeachNeedData());
        listofAllItems.add(getCarNeedData());
        return listofAllItems;
    }


    public void persistAllData(){
        List<List<Items>> listofAllItems = getAllData();
        for(List<Items> list: listofAllItems){
            for(Items items:list){
                database.mainDao().saveItem(items);
            }
        }
        System.out.println("Data Added");
    }

    public void persistDataByCategory(String category,Boolean onlyDelete){
        try{
            List<Items> list = deleteAndGetListByCategory(category, onlyDelete);
            if (!onlyDelete) {
                for (Items item: list){
                    database.mainDao().saveItem(item);
                }
                Toast.makeText(context, category + "Reset Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, category + "Reset Successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Items> deleteAndGetListByCategory(String category,Boolean onlyDelete){
        if(onlyDelete){
            database.mainDao().deleteAllByCategory(category,MyConstants.SYSTEM_SMALL);
        } else {
            database.mainDao().deleteAllByCategory(category);
        }

        switch (category){
            case MyConstants.BASIC_NEEDS_CAMEL_CASE:
                return getBasicData();

            case MyConstants.CLOTHING_CAMEL_CASE:
                return getClothingData();

            case MyConstants.PERSONAL_CARE_CAMEL_CASE:
                return getPersonalCareData();

            case MyConstants.BABY_NEEDS_CAMEL_CASE:
                return getBabyNeedData();

            case MyConstants.HEALTH_CAMEL_CASE:
                return getHealthData();

            case MyConstants.TECHNOLOGY_CAMEL_CASE:
                return getTechnologyData();

            case MyConstants.FOOD_CAMEL_CASE:
                return getFoodNeedData();

            case MyConstants.BEACH_SUPPLIES_CAMEL_CASE:
                return getBeachNeedData();

            case MyConstants.CAR_SUPPLIES_CAMEL_CASE:
                return getCarNeedData();

            default:
                return new ArrayList<>();


        }
    }

}
