Name: Arthur Tacbobo III
Section: BSIT 1-2

## Question 1
Answer: The list is typed ArrayList<Ride> to maintain polymorphism. This allows the manager to store and manage any type of ride (such as Jeepney, Taxi, Bus, etc.) in a single collection, rather than being restricted to only one specific vehicle type.

## Question 2
Answer: You must check instanceof to prevent a ClassCastException at runtime. Since the list contains generic Ride objects, checking instanceof StudentDiscount ensures that the object actually implements that interface before you safely cast it.