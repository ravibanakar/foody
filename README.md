# foody

Order Allocation logic is part of OrderAllocationService.java and allocating based on ratings is in Partner.java (Comparable)
Steps
 - Get all the delivery partners based on the resturant (pickup) address with an assumption of 2 Kms radius.
 - Added a logic to get the distance from coordinates or latitude/longitude
 - Sort the delivery partners based on te ratings (Comparable is used to sort based on rating). Have used Java 8 feature
 - Put it in a map based on the nearest distance as more than one good rating delivery partners will be there
 - Have used Collections utility class to get the delivery partner based on least allocated orders. Have added status in the order, so that partners with already delviered will be considered
