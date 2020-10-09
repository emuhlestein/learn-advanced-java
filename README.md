# Project for learning advanced features of the Java programming language
## HashMap
### merge() method

The following code snippet increments the quantity of a product that is contained in a map.  
The first checks to see if the key is valid. If the key is not valid, the get() method will  
return null. The new key and quantity are then inserted into the map. If the key is valid, the  
existing quantity is added to the new quantity and the result is then inserted into the map.  

```
Integer prodQty = qtyMap.get(product);  
if(prodQty == null) {  
    qtyMap.put(product, qty);  
} else {  
    qtyMap.put(product, prodQty + qty);  
}  
```
Note: The double colon (::) operator also known as the method reference operator.  
 
This can be replaced with the merge() method as follows:  

```$xslt
qtyMap.merge(product, qty, Integer::sum);
```
