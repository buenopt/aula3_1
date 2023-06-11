import bueno.fernando.MathOps;
import bueno.fernando.Somatoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SomatoriaTest {
    @Mock
    MathOps mathOps;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSomaDeFatoriais_Caso1() {
        // Arranjo
        Somatoria somatoria = new Somatoria(mathOps);
        int[] numeros = {3, 4};

        //configura o retorno simulado do método fatorial(3) para o valor 6.
        when(mathOps.fatorial(3)).thenReturn(6);

        // configura o retorno simulado do método fatorial(4) para o valor 24.
        when(mathOps.fatorial(4)).thenReturn(24);

       //Execução do método somaDeFatoriais() passando o array numeros como argumento: int resultado = somatoria.somaDeFatoriais(numeros);
       //O método somaDeFatoriais() é executado com o array {3, 4} e retorna o resultado da soma dos fatoriais dos números 3 e 4.
        int resultado = somatoria.somaDeFatoriais(numeros);

        // Assert
        assertEquals(30, resultado);
        verify(mathOps, times(1)).fatorial(3);
        verify(mathOps, times(1)).fatorial(4);
    }

    @Test
    public void testSomaDeFatoriais_Caso2() {
        // Arrange
        Somatoria somatoria = new Somatoria(mathOps);
        int[] numeros = {0, 1, 2, 3, 4};

        // Configure o comportamento simulado do método fatorial(0)
        when(mathOps.fatorial(0)).thenReturn(1);

        // Configure o comportamento simulado do método fatorial(1)
        when(mathOps.fatorial(1)).thenReturn(1);

        // Configure o comportamento simulado do método fatorial(2)
        when(mathOps.fatorial(2)).thenReturn(2);

        // Configure o comportamento simulado do método fatorial(3)
        when(mathOps.fatorial(3)).thenReturn(6);

        // Configure o comportamento simulado do método fatorial(4)
        when(mathOps.fatorial(4)).thenReturn(24);

        // Act
        int resultado = somatoria.somaDeFatoriais(numeros);

        // Assert
        assertEquals(34, resultado);
        verify(mathOps, times(1)).fatorial(0);
        verify(mathOps, times(1)).fatorial(1);
        verify(mathOps, times(1)).fatorial(2);
        verify(mathOps, times(1)).fatorial(3);
        verify(mathOps, times(1)).fatorial(4);
    }

}
