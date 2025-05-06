package net.itinajero;

import net.itinajero.model.Categoria;
import net.itinajero.model.Vacante;
import net.itinajero.repository.CategoriasRepository;
import net.itinajero.repository.VacantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepository repoCategorias;

	@Autowired
	private VacantesRepository repoVacantes;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("=================== RUNNING ===================");
		//save();
		//searchById(8);
		//update(1,"Ing Software","Developing Software");
		//deleteByID(1);
		//countAllRegisters();
		//deleteAllRows();

//		List<Integer> idsToSearch = new LinkedList<>();
//		idsToSearch.add(2); idsToSearch.add(8); idsToSearch.add(11);
//		findRowsByID(idsToSearch);

		//searchAllCategoria();

		//existCategoryID(23);
		//saveAListofCategories();

		//============ JPA ===============
		//searchAllByJPA();
		//delateAllByJPA();
		//searchAllSortedDescJPA();
		//searchByPaginationJPA(0,3);
		//searchallByPaginationSORTED(0,3);

		//============ VACANTES ============
		saveVacante();
		searchVacantes();
	}

	//=== Vacantes

	private void saveVacante(){
		System.out.println("============= SAVING A VACANT REGISTER =============");
		Vacante vac = new Vacante();

		vac.setNombre("==> VacantName1");
		vac.setDescription("VacantDescription1");
		vac.setFecha(new Date());
		vac.setSalario(12.22);
		vac.setDestacado(1);
		vac.setImagen("no-image.jpg");
		vac.setEstatus("active");
		vac.setDetalles("<h2> SomeDetails </h2>");

		Categoria cat = new Categoria();
		cat.setId(5);
		vac.setCategoria(cat);

		repoVacantes.save(vac);
		System.out.println(vac);
		//System.out.println(cat.toString());
		System.out.println("=============                           =============");
	}

	private void searchVacantes(){

		System.out.println("============= SEARCHING A VACANT REGISTER =============");
		List<Vacante> lista = repoVacantes.findAll();

		for (Vacante ptrVacante : lista) {
			String categoriaNombre = ptrVacante.getCategoria() != null
					? ptrVacante.getCategoria().getNombre()
					: "Sin categoría";

			System.out.println(ptrVacante.getId() + " " + ptrVacante.getNombre() +
					" Categoria: " + categoriaNombre);
		}

		System.out.println("============= SEARCHING A VACANT REGISTER =============");
	}

	//===========================

	private void searchallByPaginationSORTED(int pageNumber,int pageSize){
		System.out.println("============= SEARCH ALL PAGINATION SORTED BY NOMBRE JPA =============");
		Page<Categoria> page = repoCategorias.findAll(PageRequest.of(
				pageNumber,pageSize,Sort.by("nombre")));

		System.out.println("Total registers:" + page.getTotalElements());
		System.out.println("Total pages:" + page.getTotalPages());

		for(Categoria ptrCat: page.getContent()){
			System.out.println(ptrCat.getId() + " " + ptrCat.getNombre());
		}
		System.out.println("============= SEARCH ALL PAGINATION SORTED BY NOMBRE JPA =============");
	}

	private void searchByPaginationJPA(int pageNumber , int pageSize){
		System.out.println("============= SEARCH ALL PAGINATION JPA =============");
		Page<Categoria> page = repoCategorias.findAll(PageRequest.of(pageNumber,pageSize));
		System.out.println("Total registers:"+ page.getTotalElements());
		System.out.println("Total pages:"+ page.getTotalPages());
		for(Categoria ptrCat: page.getContent()){
			System.out.println(ptrCat.getId() + " " + ptrCat.getNombre());
		}
		System.out.println("============= SEARCH ALL PAGINATION JPA =============");
	}

	private void searchAllSortedDescJPA(){
		System.out.println("============= SEARCH ALL AND SORT DESC JPA =============");
		List<Categoria> catList = repoCategorias.findAll(Sort.by("nombre").descending());
		for(Categoria ptrCat: catList){
			System.out.println(ptrCat.getId() + " " + ptrCat.getNombre());
		}
		System.out.println("=============                              =============");
	}

	private void searchAllByJPA(){
		System.out.println("============= SEARCH ALL BY JPA =============");
		List<Categoria> listCategoria = repoCategorias.findAll();
		for(Categoria ptrCategoria : listCategoria){
			System.out.println("ID:"+ptrCategoria.getId()+" Name:"+ptrCategoria.getNombre());
		}
		System.out.println("=============                    =============");
	}

	private void delateAllByJPA(){
		System.out.println("============= DELETE ALL BY JPA =============");
		repoCategorias.deleteAllInBatch();
		System.out.println("============= DELETE ALL BY JPA =============");
	}

	private void save(){ //INSERT
		System.out.println("============= SAVING A REGISTER =============");
		Categoria cat = new Categoria();
		cat.setDescripcion("A new description");
		cat.setNombre("Finanzas");
		repoCategorias.save(cat);
		System.out.println(cat);
		//System.out.println(cat.toString());
		System.out.println("=============                   =============");
	}

	private void searchById(int Id){ //SELECT
		System.out.println("============= SERCHING BY ID =============");
		Optional<Categoria> optional = repoCategorias.findById(Id);

		if(optional.isPresent()){
			System.out.println(optional.get());
		}else{
			System.out.println("The Category object wasnt founded");
		}
		System.out.println("=============                   =============");
	}

	private void update(int Id,String nombre,String Description){
		System.out.println("============= UPDATE BY ID =============");
		Optional<Categoria> optional = repoCategorias.findById(Id);
		if(optional.isPresent()){
			Categoria getCat = optional.get();
			getCat.setNombre(nombre);
			getCat.setDescripcion(Description);
			repoCategorias.save(getCat); // <====================== Save Update
			System.out.println(getCat);
		}else{
			System.out.println("The row/object do not exist");
		}
		System.out.println("=============                =============");
	}

	private void deleteByID(int Id){
		System.out.println("============= DELETE BY ID =============");
		Optional<Categoria> optional = repoCategorias.findById(Id);
		if(optional.isPresent()){
			repoCategorias.deleteById(Id);
		}else{
			System.out.println("The row/object do not exist");
		}
		System.out.println("=============                =============");
	}

	private void countAllRegisters(){ //INSERT
		System.out.println("============= COUNTING REGISTERS =============");
		long count = repoCategorias.count();
		System.out.println("Total Categorories: " + count);
		System.out.println("=============                    =============");
	}

	private void deleteAllRows(){
		System.out.println("============= DELETING ALL REGISTERS =============");
		repoCategorias.deleteAll();
		System.out.println("=============                        =============");
	}

	private void findRowsByID(List<Integer> listIdToSearch){
//		System.out.println("============= FIND ALL OCCURRENCES BY ID =============");
//		Iterable<Categoria> categoriasFounded = repoCategorias.findAllById(listIdToSearch);
//		int counter = 0;
//		for(Categoria catPtr : categoriasFounded){
//
//			if(catPtr != null)
//				System.out.println(catPtr);
//			else
//				System.out.println("id [" + listIdToSearch.get(counter) + "] not found");
//		counter++;
//		}
//		System.out.println("=============                             =============");
		System.out.println("============= FIND ALL OCCURRENCES BY ID =============");

		for (Integer id : listIdToSearch) {
			Optional<Categoria> cat = repoCategorias.findById(id);
			if (cat.isPresent()) {
				System.out.println(cat.get());
			} else {
				System.out.println("id [" + id + "] not found");
			}
		}

		System.out.println("=============                             =============");
	}

	private void searchAllCategoria(){
		System.out.println("============= DISPLAYING ALL ROWS =============");
		Iterable<Categoria> catList = repoCategorias.findAll();
		for(Categoria ptrCat: catList){
			System.out.println(ptrCat);
		}
		System.out.println("=============                     =============");
	}

	private void existCategoryID(int ID){
		System.out.println("============= Category EXIST? =============");
		boolean exist = repoCategorias.existsById(ID);
		System.out.println("The category exis?: " +exist);
		System.out.println("=============                 =============");
	}

	private void saveAListofCategories(){
		System.out.println("============= SAVE A LIST OF CATEGORIES =============");
		List<Categoria> cat = getListOfCategorias();
		repoCategorias.saveAll(cat);
		System.out.println("=============                           =============");
	}
	private List<Categoria> getListOfCategorias(){
		List<Categoria> catList = new LinkedList<>();

		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		Categoria cat3 = new Categoria();


		cat1.setDescripcion("A new description");
		cat1.setNombre("Finanzas1");

		cat2.setDescripcion("A new description");
		cat2.setNombre("Finanzas2");

		cat3.setDescripcion("A new description");
		cat3.setNombre("Finanzas3");

		catList.add(cat1); catList.add(cat2); catList.add(cat3);
		return catList;
	}

}
