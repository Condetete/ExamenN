
/**
 * @author Mikel Conde
 * @version 8.0, 22/05/2020
 *
 */

public class Libro {
	// Atributos de la clase libro
	String titulo;
	String ISBN;
	String autor;
	String editorial;

	public Libro(String titulo, String ISBN, String autor, String editorial)
	/*
	 * Constructor con parametros.
	 * 
	 * @param titulo
	 * 
	 * @param ISBN
	 * 
	 * @param EDITORIAL
	 */
	{
		this.titulo = titulo;
		this.ISBN = ISBN;
		this.autor = autor;
		this.editorial = editorial;
	}

	public boolean checkISBN10() {
		/*
		 * Metodo para checkear el ISBN de 10 caracteres.
		 * 
		 * @return el resultado del checkeo de los 10 caracteres
		 */
		boolean result = false;
		int calculo = 0;
		int dc = 0;
		if (this.ISBN.length() == 10) {
			for (int i = 0; i < 9; i++) {
				int pos = Integer.parseUnsignedInt(String.valueOf(this.ISBN.charAt(i)));
				calculo += pos * (i + 1);
			}

			if (this.ISBN.charAt(9) == 'X')
				dc = 10;
			else
				dc = Integer.parseUnsignedInt(String.valueOf(this.ISBN.charAt(9)));

			if (calculo % 11 == dc)
				result = true;
		}

		return result;
	}

	public boolean checkISBN13() {
		/*
		 * Metodo para checkear el ISBN de 13 caracteres.
		 * @return el resultado del checkeo de los 13 caracteres
		 */
		boolean result = false;
		int pares = 0;
		int impares = 0;

		if (this.ISBN.length() == 13) {
			for (int i = 0; i < 13; i++) {
				int pos = Integer.parseUnsignedInt(String.valueOf(this.ISBN.charAt(i)));
				if ((i + 1) % 2 == 0)
					pares += pos;
				else
					impares += pos;

			}

			if ((impares + 3 * pares) % 10 == 0)
				result = true;
		}

		return result;
	}

}