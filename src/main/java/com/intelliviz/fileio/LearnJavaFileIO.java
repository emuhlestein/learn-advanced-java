package com.intelliviz.fileio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LearnJavaFileIO {
    public static void main(String[] args) throws IOException {
        String filename = "products.txt";
        BufferedReader input = null;

        try {
            createFile(filename);

            input = new BufferedReader(new FileReader("products.txt"));

            // Map<Product, Map<Brand, Qty>>
            Map<String, Map<String, Integer>> prodMap = new HashMap<>();

            // Map<Product, Integer>
            Map<String, Integer> qtyMap = new HashMap<>();

            int numOrders = 0;
            String line;
            while((line = input.readLine()) != null) {
                String[] tokens = line.split(",");
                String product = tokens[2];

                int qty = Integer.parseInt(tokens[3]);
                String brand = tokens[4];

                Map<String, Integer> brandMap = prodMap.get(product);
                if(brandMap == null) {
                    brandMap = new HashMap<>();
                    brandMap.put(brand, 1);
                    prodMap.put(product, brandMap);
                } else {
                    brandMap.merge(brand, 1, Integer::sum);
                }

                qtyMap.merge(product, qty, Integer::sum);

                numOrders++;
            }

            System.out.println("Average cost per order");
            for(Map.Entry<String, Integer> entry : qtyMap.entrySet()) {
                float ave = (float)entry.getValue() / (float)numOrders;
                System.out.println(entry.getKey() + ": " + ave);
            }

            System.out.println("\nMost popular brand");
            for(Map.Entry<String, Map<String, Integer>> entry : prodMap.entrySet()) {
                Map<String, Integer> brandMap = entry.getValue();
                String brand = null;
                int max = 0;
                for(Map.Entry<String, Integer> brandEntry : brandMap.entrySet()) {
                    int qty = brandEntry.getValue();
                    if(qty > max) {
                        max = qty;
                        brand = brandEntry.getKey();
                    }
                }
                System.out.println(entry.getKey() + ": " + brand);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                input.close();
            }
        }
    }

    private static void createFile(String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("1,utah,shoe,1,nike");
            pw.println("2,texas,shoe,2,new balance");
            pw.println("3,oregon,shoe,4,nike");
            pw.println("4,utah,shoe,3,nike");
            pw.println("4,utah,hat,2,goorin");
            pw.println("5,utah,hat,3,goorin");
            pw.println("6,utah,hat,3,goorin");
            pw.println("7,utah,hat,3,stetson");
            pw.println("8,utah,hat,3,stetson");
            pw.println("9,utah,hat,3,stetson");
            pw.println("10,utah,hat,3,stetson");
        }
    }
}
