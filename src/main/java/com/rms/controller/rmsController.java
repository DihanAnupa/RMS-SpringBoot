package com.rms.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rms.model.*;
import com.rms.repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class rmsController {

////////////////////////////////////////// FOOD ITEMS /////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	foodItemRepository foodItemRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveItems")
	public List<foodItem> getAllItems() {
		List<foodItem> fI = new ArrayList<>();
		foodItemRepo.findAll().forEach(fI::add);
		return fI;
	}
	
	//add items to the table
	@PostMapping("/addItems")
	public void addItem(@RequestBody foodItem foodItem) {
		foodItemRepo.save(foodItem);
	}
	
	//updates item by Item ID
	@PutMapping("/updateItem/{itemID}") 
	public void updateFoodItemByItemId(@PathVariable Long itemID, @RequestBody foodItem foodItem) {
		foodItemRepo.save(foodItem); 
	} 
	
	//retrieve item by name
	@GetMapping("/retrieveItems/{itemName}")
	public Optional<foodItem> getFoodItemByName(@PathVariable String itemName){
		return foodItemRepo.getFoodItemByItemName(itemName); 
	} 
	
	//delete food item by item name
	@DeleteMapping("/deleteItem/{itemName}")  
	public void deleteFoodItembyItemName(@PathVariable String itemName) {
		foodItemRepo.deleteFoodItemByItemName(itemName);
	}
	
	//delete food item by item ID
	@DeleteMapping("/deleteFoodItem/{itemID}")  
	public void deleteFoodItembyItemID(@PathVariable String itemID) {
	foodItemRepo.deleteById(itemID);
	} 
			
	//delete all food items
	@DeleteMapping("/deleteAllFoodItems")  
	public void deleteAllFoodItems() {
	foodItemRepo.deleteAll();
	} 
	
/////////////////////////////////////////////// CHEF ////////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	chefRepository chefRepo;
	//retrieve all the items from the table
		@GetMapping("/retrieveEmployee/Chefs")
		public List<chef> getAllChefs() {
			List<chef> fI = new ArrayList<>();
			chefRepo.findAll().forEach(fI::add);
			return fI;
		}
	
	//add chef to the db
	@PostMapping("/addEmployee/chef")
	public void addChef(@RequestBody chef chef) {
		chefRepo.save(chef);
	}
	
	
	
	//retrieve employee last name
	@GetMapping("/retrieveEmployee/chef/{chefId}")
	public Optional<chef> getChefById(@PathVariable String chefId) { 
		return chefRepo.findById(chefId);
	}
	
	//update employee chef by id
	@PutMapping("/updateEmployeeChef/{chefId}")
	public void updateChefbyChefId(@RequestBody chef chef, @PathVariable String chefId) { //changed long to string
		 chefRepo.save(chef);
	}
	
	//delete chef by id
	@DeleteMapping("/deleteEmployee/chef/{chefId}")
	public void deleteChefById(@PathVariable String chefId) {
		chefRepo.deleteById(chefId);
	}
	
	//delete all chefs
		@DeleteMapping("/deleteAllChefs")
		public void deleteAllChefs() {
			chefRepo.deleteAll();
		}
		
//////////////////////////////////////////// CUSTOMER ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	customerRepository customerRepo;
	
	//add customer to the database
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer Customer) {
		customerRepo.save(Customer);
	}
	
	//updates customer details by ID
	@PutMapping("/updateCustomer/{customerID}")
	public void updateCustomerByCustomerId(@RequestBody Customer Customer, @PathVariable Long customerID) {
		customerRepo.save(Customer);
	}
	
	//Retrieve all the customers
	@GetMapping("/retrieveCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}
	
	//Retrieve Customers by type
	@GetMapping("/retrieveCustomer/{type}")
	public Optional<Customer> getCustomerByType(@PathVariable String type){
		return customerRepo.getCustomerByType(type); 
	}
	
	//Delete Customer by ID
	@DeleteMapping("/deleteCustomer/{customerID}")
	public void deleteCustomerByCustomerID(@PathVariable Long customerID) {
		customerRepo.deleteById(customerID);
	}
	
//////////////////////////////////////////// REVIEWS ///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reviewRepository reviewRepo;
	
	//add reviews to the database by customer and item id
	@PostMapping("/addReview")
	public void addReview(@RequestBody review review) {
		reviewRepo.save(review);
	} 
	
	//Updates review by review ID
	@PutMapping("/updateReview/{reviewID}")
	public void updateReviewByReviewID(@RequestBody review review, @PathVariable Long reviewID) {
		reviewRepo.save(review);
	}
	
	//retrieves all the reviews
	@GetMapping("/retrieveReviews")
	public List<review> getAllReviews() {
		List<review> reviews = new ArrayList<>();
		reviewRepo.findAll().forEach(reviews::add);
		return reviews;
	} 
	
	// Deletes Review by ID
	@DeleteMapping("/deleteReview/{reviewID}")
	public void deleteReviewByReviewID(@PathVariable Long reviewID) {
		reviewRepo.deleteById(reviewID);
	}

///////////////////////////////////////////// RESERVATION //////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reservationRepository reservationRepo;
	
	// Add a reservation by type
	@PostMapping("/addReservation")
	public void addReservation(@RequestBody Reservation reservation) {
		reservationRepo.save(reservation);
	}
	
	// Retrieves all the reservations
	@GetMapping("/retrieveReservations")
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		reservationRepo.findAll().forEach(reservations::add);
		return reservations;
	} 
	
	// Retrieves reservation by type
	@GetMapping("/retrieveReservation/{type}")
	public Optional<Reservation> getReservationByType(@PathVariable String type){
		return reservationRepo.getReservationByType(type);  
	} 
	
	//deletes reservation by reservation id
	@DeleteMapping("/deleteReservation/{reservationID}")
	public void deleteReservationByReservationID(@PathVariable Long reservationID) {
		reservationRepo.deleteById(reservationID);
	}

///////////////////////////////////////////// CASHIER //////////////////////////////////////////////////////////////////////////////////////////////////////
 
	@Autowired
	cashierRepository cashierRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveEmployee/Cashiers")
	public List<Cashier> getAllCashiers() {
		List<Cashier> fI = new ArrayList<>();
		cashierRepo.findAll().forEach(fI::add);
		return fI;
	}


	
	//add cashier to the db
	@PostMapping("/addEmployee/cashier")
	public void addChef(@RequestBody Cashier Cashier) {
		cashierRepo.save(Cashier);
	}
	

	//update employee cashier by id
	@PutMapping("/updateEmployeeCashier/{cashierID}")
	public void updateCashierbyCashierId(@RequestBody Cashier Cashier, @PathVariable String cashierID) { //changed long to string
		 cashierRepo.save(Cashier);
	}
	
	//delete cashier by id
	@DeleteMapping("/deleteEmployee/cashier/{cashierID}")
	public void deleteCashierById(@PathVariable String cashierID) {
		cashierRepo.deleteById(cashierID);
	}
	
	//delete all cashiers
	@DeleteMapping("/deleteAllCashiers")
	public void deleteAllCashiers() {
		cashierRepo.deleteAll();
	}
	
	
	
	
//////////////////////////////////////////// RESTAURANT MANAGER ////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Autowired
	restaurantManagerRepository restManagerRepo;
	
	//retrieve all the items from the table
			@GetMapping("/retrieveEmployee/RestaurantManagers")
			public List<RestaurantManager> getAllRestaurantManagers() {
				List<RestaurantManager> fI = new ArrayList<>();
				restManagerRepo.findAll().forEach(fI::add);
				return fI;
			}
			
	
		
			
	@PostMapping("/addEmployee/RestaurantManager")
	public void addRestaurantManager(@RequestBody RestaurantManager RestaurantManager) {
		restManagerRepo.save(RestaurantManager);
	}
	
	//update employee Restaurant Manager by id
		@PutMapping("/updateEmployeeRestaurantManager/{restaurantManagerID}")
		public void updateRestaurantManagerbyRestaurantManagerID(@RequestBody RestaurantManager RestaurantManager, @PathVariable String restaurantManagerID) { //changed long to string
			 restManagerRepo.save(RestaurantManager);
		}
		
		//delete Restaurant Manager by id
		@DeleteMapping("/deleteEmployee/RestaurantManager/{restaurantManagerID}")
		public void deleteRestaurantManagerById(@PathVariable String restaurantManagerID) {
			restManagerRepo.deleteById(restaurantManagerID);
		}
		
		//delete all Restaurant Managers
		@DeleteMapping("/deleteAllRestaurantManagers")
		public void deleteAllRestaurantManagers() {
			restManagerRepo.deleteAll();
		}
		
			
	
//////////////////////////////////////////// INVENTORY MANAGER ///////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	inventoryManagerRepository invManagerRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveEmployee/InventoryManagers")
	public List<InventoryManager> getAllInventoryManagers() {
		List<InventoryManager> fI = new ArrayList<>();
		invManagerRepo.findAll().forEach(fI::add);
		return fI;
	}
	
	
	@PostMapping("/addEmployee/InventoryManager")
	public void addInventoryManager(@RequestBody InventoryManager InventoryManager) {
		invManagerRepo.save(InventoryManager);
	}
	
	@DeleteMapping("/deleteEmployee/InventoryManager/{inventoryManagerID}")
	public void deleteInventoryManager(@PathVariable String inventoryManagerID) {
		invManagerRepo.deleteById(inventoryManagerID);
	}

	//update employee Inventory Manager by id
	@PutMapping("/updateEmployeeInventoryManager/{inventoryManagerID}")
	public void updateInventoryManagerbyInventoryManagerID(@RequestBody InventoryManager InventoryManager, @PathVariable String inventoryManagerID) { //changed long to string
	invManagerRepo.save(InventoryManager);
	}
			
	//delete all Inventory Managers
	@DeleteMapping("/deleteAllInventoryManagers")
	public void deleteAllInventoryManagers() {
	invManagerRepo.deleteAll();
	}
	
	
//////////////////////////////////////////// PAYMENT ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	paymentRepository paymentRepo;
	@PostMapping("/addPayment")
	public void addPayment(@RequestBody Payment Payment) {
		paymentRepo.save(Payment);
	}
	
//////////////////////////////////////////// DOCUMENTATION ///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	documentationRepository docRepo;
	@PostMapping("/addDoc/{type}")
	public void addDocument(@RequestBody Documentation Documentation, @PathVariable String type) {
		docRepo.save(Documentation);
	}

///////////////////////////////////////////// REPORT //////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reportRepository reportRepo;
	@PostMapping("/addReport")
	public void addReport(@RequestBody Report Report) {
		reportRepo.save(Report);
	}

///////////////////////////////////////////// INVOICE ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	invoiceRepository invoiceRepo;
	@PostMapping("/addInvoice")
	public void addInvoice(@RequestBody Invoice Invoice) {
		invoiceRepo.save(Invoice);
	}
	
///////////////////////////////////////////// INGREDIENTS ////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	ingredientRepository ingRepo;
	@PostMapping("/addIngredients")
	public void addIngredient(@RequestBody Ingredient Ingredient) {
		ingRepo.save(Ingredient);
	}
	
	@DeleteMapping("deleteIngredients/{ingredientID}")
	public void deleteIngredientByID(@PathVariable Long ingredientID) {
		ingRepo.deleteById(ingredientID);
	}

///////////////////////////////////////////// ORDER //////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	orderRepository orderRepo;
	@PostMapping("/addOrder")
	public void addOrder(@RequestBody Order Order) {
		orderRepo.save(Order);
	}
	
//////////////////////////////////////////// PLACE ORDER  ///////////////////////////////////////////////////////////////////////////////////////////////////
	
	//New Order class
	
	@Autowired
	placeOrderRepository pOrderRepo;
	
	//Add new order
	@PostMapping("/addpOrder")
	public void addOrder2(@RequestBody placeOrder pOrder) {
		pOrderRepo.save(pOrder);
	}
	
	
	//retrieve all orders
	@GetMapping("/retrieveOrders")
	public List<placeOrder> getAllOrders() {
		List<placeOrder> fI = new ArrayList<>();
		pOrderRepo.findAll().forEach(fI::add);
		return fI;
	}
	

	//update order by id
	@PutMapping("/updatePlaceOrder/{pOrderID}")
	public void updatePlaceOrderbyID(@RequestBody placeOrder pOrder, @PathVariable String pOrderID) { 
		pOrderRepo.save(pOrder);
	}

	//delete order by id
	@DeleteMapping("/deletePlaceOrder/{pOrderID}")
	public void deletePlaceOrderById(@PathVariable String pOrderID) {
		pOrderRepo.deleteById(pOrderID);
	}

	//delete all orders
	@DeleteMapping("/deleteAllOrders")
	public void deleteAllPlaceOrders() {
		pOrderRepo.deleteAll();
	}
	
} 
