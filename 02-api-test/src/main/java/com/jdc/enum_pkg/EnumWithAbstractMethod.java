package com.jdc.enum_pkg;

public class EnumWithAbstractMethod {
	public static void main(String[] args) {

		// Test different operations
		takeOperation(Operations.PLUS);
		takeOperation(Operations.MINUS);
		takeOperation(Operations.MUL);
		takeOperation(Operations.DIV);
	}

	public static void takeOperation(Operations ope) {

		int a = 10;
		int b = 0;

		var opera = ope;
		var result = opera.apply(a, b);

		String output = switch (opera) {
		case PLUS -> {
			yield String.format("%d + %d = %d", a, b, result);
		}
		case MINUS -> {
			yield String.format("%d + %d = %d", a, b, result);
		}
		case MUL -> {
			yield String.format("%d + %d = %d", a, b, result);
		}
		case DIV -> {
			if(b <= 0) {
				throw new IllegalArgumentException("Operand b is greater than zero");
			} else {
				yield String.format("%d + %d = %d", a, b, result);
			}
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + opera);
		};

		System.out.println(output);
	}
}

enum Operations {
	PLUS {
		@Override
		public int apply(int a, int b) {
			return a + b;
		}
	},
	MINUS {
		@Override
		public int apply(int a, int b) {
			return a - b;
		}
	},
	MUL {
		@Override
		public int apply(int a, int b) {
			return a * b;
		}
	},
	DIV {
		@Override
		public int apply(int a, int b) {
			return a / b;
		}
	};

	public abstract int apply(int a, int b);
}
