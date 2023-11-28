
import java.util.ArrayList; 
class ChicagoPizzaStore extends PizzaStore 
{Pizza createPizza(String item) 
{if (item.equals("cheese")) 
{return new ChicagoStyleCheesePizza(); 
} 
else if (item.equals("veggie")) 
{return new ChicagoStyleVeggiePizza(); 
} 
else if (item.equals("clam")) 
{return new ChicagoStyleClamPizza(); 
} 
else if (item.equals("pepperoni")) 
{return new ChicagoStylePepperoniPizza(); 
} 
else return null; 
}} 
class ChicagoStyleCheesePizza extends Pizza 
{public ChicagoStyleCheesePizza() 
{ 
name = "Chicago Style Deep Dish Cheese Pizza"; 
dough = "Extra Thick Crust Dough"; 
sauce = "Plum Tomato Sauce"; 
toppings.add("Shredded Mozzarella Cheese"); 
}

void cut() 
{System.out.println("Cutting the pizza into square slices"); 
}} 
class ChicagoStyleClamPizza extends Pizza 
{public ChicagoStyleClamPizza() 
{ 
name = "Chicago Style Clam Pizza"; 
dough = "Extra Thick Crust Dough"; 
sauce = "Plum Tomato Sauce"; 
toppings.add("Shredded Mozzarella Cheese"); 
toppings.add("Frozen Clams from Chesapeake Bay"); 
} 
void cut() 
{System.out.println("Cutting the pizza into square slices"); 
}} 
class ChicagoStylePepperoniPizza extends Pizza 
{public ChicagoStylePepperoniPizza() 
{ 
name = "Chicago Style Pepperoni Pizza"; 
dough = "Extra Thick Crust Dough"; 
sauce = "Plum Tomato Sauce"; 
toppings.add("Shredded Mozzarella Cheese"); 
toppings.add("Black Olives"); 
toppings.add("Spinach"); 
toppings.add("Eggplant"); 
toppings.add("Sliced Pepperoni"); 
} 
void cut() 
{System.out.println("Cutting the pizza into square slices"); 
}} 
class ChicagoStyleVeggiePizza extends Pizza 
{public ChicagoStyleVeggiePizza() 
{name = "Chicago Deep Dish Veggie Pizza"; 
dough = "Extra Thick Crust Dough"; 
sauce = "Plum Tomato Sauce"; 
toppings.add("Shredded Mozzarella Cheese"); 
toppings.add("Black Olives"); 
toppings.add("Spinach"); 
toppings.add("Eggplant"); 
} 
void cut() 
{System.out.println("Cutting the pizza into square slices"); 
}} 
class DependentPizzaStore 
{public Pizza createPizza(String style, String type) 
{ Pizza pizza = null; 
if (style.equals("NY")) 
{if (type.equals("cheese")) 
{pizza = new NYStyleCheesePizza(); 
} 
else if (type.equals("veggie")) 
{pizza = new NYStyleVeggiePizza(); 
} 
else if (type.equals("clam")) 
{pizza = new NYStyleClamPizza(); 
} 
else if (type.equals("pepperoni")) 
{pizza = new NYStylePepperoniPizza(); 
}} 
else if (style.equals("Chicago")) 
{if (type.equals("cheese")) 
{pizza = new ChicagoStyleCheesePizza(); 
} 
else if (type.equals("veggie")) 
{pizza = new ChicagoStyleVeggiePizza(); 
} 
else if (type.equals("clam")) 
{pizza = new ChicagoStyleClamPizza(); 
} 
else if (type.equals("pepperoni")) 
{pizza = new ChicagoStylePepperoniPizza(); 
}} 
else 
{System.out.println("Error: invalid type of pizza"); 
return null; 
} 
pizza.prepare(); 
pizza.bake(); 
pizza.cut(); 
pizza.box(); 
return pizza; 
}} 
class NYPizzaStore extends PizzaStore 
{Pizza createPizza(String item) 
{if (item.equals("cheese")) 
{return new NYStyleCheesePizza(); 
} 
else if (item.equals("veggie")) 
{return new NYStyleVeggiePizza(); 
} 
else if (item.equals("clam")) 
{return new NYStyleClamPizza(); 
} 
else if (item.equals("pepperoni")) 
{return new NYStylePepperoniPizza(); 
} 
else return null; 
}} 
class NYStyleCheesePizza extends Pizza 
{public NYStyleCheesePizza() 
{ 
name = "NY Style Sauce and Cheese Pizza"; 
dough = "Thin Crust Dough"; 
sauce = "Marinara Sauce"; 
toppings.add("Grated Reggiano Cheese"); 
}} 
class NYStyleClamPizza extends Pizza 
{public NYStyleClamPizza() 
{ 
name = "NY Style Clam Pizza"; 
dough = "Thin Crust Dough"; 
sauce = "Marinara Sauce"; 
toppings.add("Grated Reggiano Cheese"); 
toppings.add("Fresh Clams from Long Island Sound"); 
}} 
class NYStylePepperoniPizza extends Pizza 
{public NYStylePepperoniPizza() 
{ 
name = "NY Style Pepperoni Pizza"; 
dough = "Thin Crust Dough"; 
sauce = "Marinara Sauce"; 
toppings.add("Grated Reggiano Cheese"); 
toppings.add("Sliced Pepperoni"); 
toppings.add("Garlic"); 
toppings.add("Onion"); 
toppings.add("Mushrooms"); 
toppings.add("Red Pepper"); 
}} 
class NYStyleVeggiePizza extends Pizza 
{public NYStyleVeggiePizza() 
{ 
name = "NY Style Veggie Pizza"; 
dough = "Thin Crust Dough"; 
sauce = "Marinara Sauce"; 
toppings.add("Grated Reggiano Cheese"); 
toppings.add("Garlic"); 
toppings.add("Onion"); 
toppings.add("Mushrooms"); 
toppings.add("Red Pepper"); 
}} 
abstract class Pizza 
{ 
String name; 
String dough; 
String sauce; 
ArrayList toppings = new ArrayList(); 
void prepare() 
{ 
System.out.println("Preparing " + name); 
System.out.println("Tossing dough..."); 
System.out.println("Adding sauce..."); 
System.out.println("Adding toppings: "); 
for (int i = 0; i < toppings.size(); i++) 
{System.out.println(" " + toppings.get(i)); 
}} 
void bake() 
{System.out.println("Bake for 25 minutes at 350"); 
} 
void cut() 
{System.out.println("Cutting the pizza into diagonal slices"); 
} 
void box() 
{System.out.println("Place pizza in official PizzaStore box"); 
} 
public String getName() 
{return name; 
} 
public String toString() 
{StringBuffer display = new StringBuffer(); 
display.append("---- " + name + " ----\n"); 
display.append(dough + "\n"); 
display.append(sauce + "\n"); 
for (int i = 0; i < toppings.size(); i++) 
{display.append((String )toppings.get(i) + "\n"); 
} 
return display.toString(); 
}} 
abstract class PizzaStore 
{abstract Pizza createPizza(String item); 
public Pizza orderPizza(String type) 
{Pizza pizza = createPizza(type); 
System.out.println("--- Making a " + pizza.getName() + " ---"); 
pizza.prepare(); 
pizza.bake(); 
pizza.cut(); 
pizza.box(); 
return pizza; 
}
}





public class slip4_19_30
{public static void main(String[] args) 
{ 
PizzaStore nyStore = new NYPizzaStore(); 
PizzaStore chicagoStore = new ChicagoPizzaStore(); 
Pizza pizza = nyStore.orderPizza("cheese"); 
System.out.println("Ethan ordered a " + pizza.getName() + "\n"); 
pizza = chicagoStore.orderPizza("cheese"); 
System.out.println("Joel ordered a " + pizza.getName() + "\n"); 
pizza = nyStore.orderPizza("clam"); 
System.out.println("Ethan ordered a " + pizza.getName() + "\n"); 
pizza = chicagoStore.orderPizza("clam"); 
System.out.println("Joel ordered a " + pizza.getName() + "\n"); 
pizza = nyStore.orderPizza("pepperoni"); 
System.out.println("Ethan ordered a " + pizza.getName() + "\n"); 
pizza = chicagoStore.orderPizza("pepperoni"); 
System.out.println("Joel ordered a " + pizza.getName() + "\n"); 
pizza = nyStore.orderPizza("veggie"); 
System.out.println("Ethan ordered a " + pizza.getName() + "\n"); 
pizza = chicagoStore.orderPizza("veggie"); 
System.out.println("Joel ordered a " + pizza.getName() + "\n"); 
}}