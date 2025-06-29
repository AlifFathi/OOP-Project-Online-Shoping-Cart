# Online Shopping Cart System
This project is a simple online shopping cart system built using Java. It allows users to browse products, add them to their cart, and manage their orders.

## Contributors
1. [Iman Abadi Bin Mohd Nizwan](https://github.com/imn353) (A23CS0084)
2. [Mohamed Alif Fathi Bin Abdul Latif](https://github.com/AlifFathi) (A23CS0112)

## Class Diagram

@startuml
skinparam classAttributeIconSize 0
skinparam classFontSize 10

' Start with the abstract base class at the top
abstract class User {
    -String name
    -String userID
    -String password
    +User(name, userID, password)
    +getName(): String
    +getID(): String
    +getPassword(): String
    +{abstract} showMenu(scanner, products): void
    +{abstract} showOrders(): void
    +viewProducts(products): void
    +findProductByName(products, productName): Product
}

' User implementations - side by side
class Customer {
    -Cart cart
    -ArrayList<Order> orders
    +Customer(name, userID, password)
    +getName(): String
    +getID(): String
    +getPassword(): String
    +showMenu(scanner, products): void
    +showOrders(): void
    +getOrder(): ArrayList<Order>
    -addToCart(scanner, products): void
    -removeFromCart(scanner): void
    -checkout(scanner, products): void
}

class Admin {
    -ArrayList<Customer> customers
    +Admin(name, userID, password, customers)
    +getName(): String
    +getID(): String
    +getPassword(): String
    +showMenu(scanner, products): void
    +showOrders(): void
    -restockProducts(scanner, products): void
}

' Shopping flow components - arranged in logical order
class Cart {
    -ArrayList<Item> items
    +Cart()
    +addItem(product, quantity): void
    +removeItem(name): void
    +getTotalPrice(): double
    +displayCart(): void
    +getItems(): ArrayList<Item>
    +isEmpty(): boolean
}

class Item {
    -Product product
    -int quantity
    +Item(product, quantity)
    +getQuantity(): int
    +setQuantity(quantity): void
    +addQuantity(quantity): void
    +reduceQuantity(quantity): void
    +itemName(): String
    +getItem(): Product
    +calculateTotalPrice(): double
}

class Product {
    -String name
    -double price
    -int stock
    +Product(name, price, stock)
    +getName(): String
    +getPrice(): double
    +getStock(): int
    +reStock(stock): void
    +reduceStock(quantity): void
    +inStock(quantity): boolean
}

' Transaction record
class Order {
    -Cart cart
    -double totalPrice
    -String orderDate
    +Order(cart, totalPrice, orderDate)
    +getCustomer(): Customer
    +getCart(): Cart
    +getTotalPrice(): double
    +getOrderDate(): String
    +displayOrderDetails(): void
}

' System coordinator
class OnlineShoppingCartSystem {
    +main(args): void
    +clearScreen(): void
}


' Position Customer and Admin side by side directly below User
Customer -[hidden]right- Admin

' Admin management
Admin -right-> Customer : manages

' Inheritance relationships
User <|-- Customer
User <|-- Admin

' Composition relationships
Customer *-- Cart : owns
Cart *-- Item : contains
Item o-- Product : wraps
Customer *-- Order : creates
Order *-- Cart : captures

' Hidden relationships for better spacing
Cart -[hidden]right- Order
Product -[hidden]right- Item 
User -[hidden]right- OnlineShoppingCartSystem

@enduml



