package Ex3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Product prodotto1 = new Product(111111, "HarryPotter", "Books", 150.50);
		Product prodotto2 = new Product(444444, "Topolino", "Books", 80.50);
		Product prodotto3 = new Product(555555, "SteveJobs", "Books", 400.50);
		Product prodotto4 = new Product(666666, "Giocattoli", "Baby", 40.00);
		Product prodotto5 = new Product(777777, "Biberon", "Baby", 20.60);
		Product prodotto6 = new Product(666666, "Bagnoschiuma", "Baby", 10.00);
		Product prodotto7 = new Product(888888, "Profumo", "Boys", 10.00);
		Product prodotto8 = new Product(101010, "Cintura", "Boys", 100.60);
		Product prodotto9 = new Product(121310, "Cravatta", "Boys", 90.00);


		List<Product> listaProdotti = new ArrayList<>();
		listaProdotti.add(prodotto1);
		listaProdotti.add(prodotto2);
		listaProdotti.add(prodotto3);
		listaProdotti.add(prodotto4);
		listaProdotti.add(prodotto5);
		listaProdotti.add(prodotto6);
		listaProdotti.add(prodotto7);
		listaProdotti.add(prodotto8);
		listaProdotti.add(prodotto9);
		// Esercizio2***********************************************************************
		System.err.println("Libri Filtrati:");
		List<Product> libriFiltrati = listaProdotti.stream()
				.filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();

		for (Product product : libriFiltrati) {
			System.out.println("Nome: " + product.getName() + ", Prezzo: " + product.getPrice());
		}
		// Esercizio2***********************************************************************
		Customer client1 = new Customer(11111, "Benedetto", 1);
		Customer client2 = new Customer(22222, "Giuseppe", 2);

		Customer client3 = new Customer(33333, "Marco", 2);

		List<Product> babyFiltrati = listaProdotti.stream().filter(product -> product.getCategory().equals("Baby"))
				.toList();

		List<Order> ordini = new ArrayList<>();
		Order ordine1 = new Order(00000, "Completed", LocalDate.now(), LocalDate.now().plusDays(2), babyFiltrati,
				client1);
		Order ordine2 = new Order(99999, "Pending", LocalDate.now(), LocalDate.now().plusDays(3), babyFiltrati,
				client2);
		Order ordine3 = new Order(99999, "Pending", LocalDate.of(2021, 3, 15), LocalDate.now().plusDays(3),
				babyFiltrati, client3);
		
		ordini.add(ordine1);
		ordini.add(ordine2);
		ordini.add(ordine3);
		System.err.println("Baby Filtrati:");

		for (Order product : ordini) {
			System.out.println("Id: " + product.getId() + ", Stato: " + product.getStatus() + ", DataDiOrdine"
					+ product.getOrderDate() + ", DataDiConsegna" + product.getDeliveryDate() + ", Cliente"
					+ product.getCustomer() + ", Prodotti acquistati" + babyFiltrati);
		}
		// Esercizio3 ***********************************************************************
		
		List<Product> boysProducts = listaProdotti.stream().filter(product -> product.getCategory().equals("Boys"))
				.toList();

		System.err.println("Prodotti Boys Filtrati:");
		for (Product product : boysProducts) {
			System.out.println("Nome: " + product.getName() + ", Prezzo: " + product.getPrice());
		}

		System.err.println("Prodotti Boys con sconto del 10%:");
		for (Product product : boysProducts) {
			double prezzoScontato = product.getPrice() * 0.9;
			product.setPrice(prezzoScontato);
			System.out.println("Nome: " + product.getName() + ", Prezzo scontato: " + product.getPrice());
		}

		// Esercizio4***********************************************************************

		List<Order> ordiniFiltrati = ordini.stream()
				.filter(order -> order.getCustomer().getTier() == 2
						&& order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))
						&& order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.toList();

		for (Order order : ordiniFiltrati) {
			System.err.println("Id: " + order.getId() + ", Stato: " + order.getStatus() + ", DataDiOrdine: "
					+ order.getOrderDate() + ", DataDiConsegna: " + order.getDeliveryDate() + ", Cliente: "
					+ order.getCustomer() + ", Prodotti acquistati: " + order.getProducts());
		}
	}

}

//		Product prodotto2 = new Product(222222, "Iphone 14 pro", "Elettronica", 1399.80);
//		Product prodotto3 = new Product(333333, "Quadro", "Casa", 30.60);


