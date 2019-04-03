package br.com.db1start.loja;

import java.util.Objects;

public class Checker {
		public static void notNull(Object value, String field) {
			if (Objects.isNull(value)) {
				throw new RuntimeException("Campo " + field + " é obrigatório.");
			}
		}
		public static void cpf(String cpf) {
			if (Objects.isNull(cpf) || cpf.isEmpty() || cpf.length() != 11) {
				throw new RuntimeException("CPF " + cpf + " é inválido.");
			}
		}
		public static void maiorQueZero(Double valor, String campo) {
			if (Objects.isNull(valor) || valor <= 0) {
				throw new RuntimeException("Campo " + campo + " deve ser maior que zero.");
			}	
		}
	}