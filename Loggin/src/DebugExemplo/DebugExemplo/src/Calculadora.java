package DebugExemplo.DebugExemplo.src;

public class Calculadora {
	public float calcular(float a, float b, char operacao) {
		float resultado = 0;
		float maior = 0;
		float menor = 0;

		if (b > a) {
			maior = b;
			menor = a;
		}

		switch (operacao) {
		case '+': {
			resultado = maior + menor;
			break;

		}
		case '-': {
			resultado = maior - menor;
			break;

		}
		case '/': {
			resultado = maior / menor;
			break;
		}

		case '*': {
			resultado = maior * menor;
			break;
		}

		}
		return resultado;

	}
}
