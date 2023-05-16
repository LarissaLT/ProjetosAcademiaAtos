package DebugExemplo.DebugExemplo.src;

import br.com.loggin.Log;

import java.util.Scanner;
import java.util.logging.Level;
import java.io.File;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		try {
			Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");


		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}


		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " �:" + resultado);
		}

	}

}
