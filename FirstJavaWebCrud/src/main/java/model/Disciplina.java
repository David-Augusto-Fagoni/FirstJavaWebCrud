package model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Disciplina {
	private int codigo;
	private String nome;
	private int codigoProfessor;
}
