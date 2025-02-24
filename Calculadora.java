import java.awt.BorderLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import javax.swing.JOptionPane;

/**
 * La clase Calculadora implementa una calculadora básica con interfaz gráfica
 * utilizando SWT. Permite realizar operaciones aritméticas (suma, resta, multiplicación,
 * división) y gestiona la entrada de dígitos a través de botones.
 *
 * Para su funcionamiento, es necesario que la librería SWT esté correctamente
 * configurada en el proyecto.
 *
 * @author
 *         Aurora Haro Vicente
 * @version 1.0
 */
public class Calculadora {

    // Constantes
    /** Número máximo de dígitos permitidos en la entrada. */
    final int MAX_DIGITS = 5;
    /** Modo de entrada, para introducir números. */
    final int MODE_ENTRADA = 0;
    /** Modo resultado, para mostrar el resultado de una operación. */
    final int MODE_RESULTADO = 1;

    // Variables
    /** Indica el modo actual (entrada o resultado). */
    int modo;
    /** Último dígito introducido. */
    int digito;
    /** Primer operando de la operación aritmética. */
    int valor1;
    /** Segundo operando de la operación aritmética. */
    int valor2;
    /** Cadena que representa la operación aritmética ("+", "-", "*", "/"). */
    String operacion;
    /** Bandera para determinar si se debe reinicializar el display de resultados. */
    boolean inicializa_resultado;

    /** Componente SWT que muestra el resultado en la interfaz. */
    private static Text texto_resultado;

    /**
     * Constructor de la calculadora.
     *
     * @param gui Si es true, se dibuja la interfaz gráfica de la calculadora.
     */
    public Calculadora(boolean gui) {
        // Inicialización de las variables.
        inicializa();

        if (gui == true)
            dibujaCalculadora();
    }

    /**
     * Dibuja la interfaz gráfica de la calculadora utilizando SWT.
     * Crea un {@link org.eclipse.swt.widgets.Shell} para la ventana,
     * y añade varios {@link org.eclipse.swt.widgets.Button} para los botones numéricos
     * y de operaciones, así como un {@link org.eclipse.swt.widgets.Text} para el display de resultados.
     */
    private void dibujaCalculadora() {

        Display display = Display.getDefault();
        Shell shlCalculadora = new Shell();
        shlCalculadora.setSize(259, 250);
        shlCalculadora.setText("Calculadora");

        //------------------------------------------------ -
        // Números
        //------------------------------------------------ -

        // Botón con el número 0.
        Button button_0 = new Button(shlCalculadora, SWT.NONE);
        button_0.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(0);
            }
        });
        button_0.setText("0");
        button_0.setBounds(23, 163, 40, 33);

        // Botón con el número 1.
        Button button_1 = new Button(shlCalculadora, SWT.NONE);
        button_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(1);
            }
        });
        button_1.setText("1");
        button_1.setBounds(23, 124, 40, 33);

        // Botón con el número 2.
        Button button_2 = new Button(shlCalculadora, SWT.NONE);
        button_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(2);
            }
        });
        button_2.setText("2");
        button_2.setBounds(69, 124, 40, 33);

        // Botón con el número 3.
        Button button_3 = new Button(shlCalculadora, SWT.NONE);
        button_3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(3);
            }
        });
        button_3.setText("3");
        button_3.setBounds(115, 124, 40, 33);

        // Botón con el número 4.
        Button button_4 = new Button(shlCalculadora, SWT.NONE);
        button_4.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(4);
            }
        });
        button_4.setText("4");
        button_4.setBounds(23, 85, 40, 33);

        // Botón con el número 5.
        Button button_5 = new Button(shlCalculadora, SWT.NONE);
        button_5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(5);
            }
        });
        button_5.setText("5");
        button_5.setBounds(69, 85, 40, 33);

        // Botón con el número 6.
        Button button_6 = new Button(shlCalculadora, SWT.NONE);
        button_6.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(6);
            }
        });
        button_6.setText("6");
        button_6.setBounds(115, 85, 40, 33);

        // Botón con el número 7.
        Button button_7 = new Button(shlCalculadora, SWT.NONE);
        button_7.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(7);
            }
        });
        button_7.setText("7");
        button_7.setBounds(23, 46, 40, 33);

        // Botón con el número 8.
        Button button_8 = new Button(shlCalculadora, SWT.NONE);
        button_8.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(8);
            }
        });
        button_8.setBounds(69, 46, 40, 33);
        button_8.setText("8");

        // Botón con el número 9.
        Button button_9 = new Button(shlCalculadora, SWT.NONE);
        button_9.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(9);
            }
        });
        button_9.setText("9");
        button_9.setBounds(115, 46, 40, 33);

        //------------------------------------------------ -
        // Operaciones
        //------------------------------------------------ -

        // Botón con la operación de división.
        Button button_12 = new Button(shlCalculadora, SWT.NONE);
        button_12.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("/");
            }
        });
        button_12.setText("/");
        button_12.setBounds(178, 46, 40, 33);

        // Botón con la operación de multiplicación.
        Button button_13 = new Button(shlCalculadora, SWT.NONE);
        button_13.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("*");
            }
        });
        button_13.setText("*");
        button_13.setBounds(178, 85, 40, 33);

        // Botón con la operación de suma.
        Button button_14 = new Button(shlCalculadora, SWT.NONE);
        button_14.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("+");
            }
        });
        button_14.setText("+");
        button_14.setBounds(178, 124, 40, 33);

        // Botón con la operación de resta.
        Button button_15 = new Button(shlCalculadora, SWT.NONE);
        button_15.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("-");
            }
        });
        button_15.setText("-");
        button_15.setBounds(178, 163, 40, 33);

        // Botón con la operación de igual.
        Button button_11 = new Button(shlCalculadora, SWT.NONE);
        button_11.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarIgual();
            }
        });
        button_11.setText("=");
        button_11.setBounds(69, 163, 86, 33);

        // Texto donde se visualiza el resultado.
        texto_resultado = new Text(shlCalculadora, SWT.BORDER);
        texto_resultado.setText("0");
        texto_resultado.setBounds(22, 19, 196, 21);

        shlCalculadora.open();
        shlCalculadora.layout();
        while (!shlCalculadora.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Inicializa los valores y el estado de la calculadora a los predeterminados.
     */
    public void inicializa() {
        operacion = "null";
        valor1 = 0;
        valor2 = 0;
        modo = MODE_ENTRADA;
        inicializa_resultado = true;
    }

    /**
     * Devuelve el contenido actual del display de la calculadora.
     *
     * @return el texto mostrado en el display.
     */
    public String getResultadoString (){
        return texto_resultado.getText();
    }

    /**
     * Establece el contenido del display de la calculadora.
     *
     * @param s el texto que se mostrará en el display.
     */
    public void setResultadoString(String s){
        texto_resultado.setText(s);
    }

    /**
     * Devuelve el contenido del display convertido a entero.
     *
     * @return el valor numérico del display.
     */
    public int getResultadoInt() {
        String resultado = texto_resultado.getText();
        return Integer.parseInt(resultado);
    }

    /**
     * Añade un nuevo dígito al final del contenido actual del display.
     * Si se ha inicializado el resultado, primero limpia el display.
     *
     * @param digito el dígito (0-9) a añadir.
     */
    public void anadeNuevoDigito(int digito){
        if (inicializa_resultado)
            setResultadoString("");

        String inputString = getResultadoString();

        if (inputString.indexOf("0") == 0){
            inputString = inputString.substring(1);
        }

        if ((!inputString.equals("0") || digito > 0) && inputString.length() < MAX_DIGITS){
            setResultadoString(inputString + digito);
        }

        modo = MODE_ENTRADA;
        inicializa_resultado = false;
    }

    /**
     * Ejecuta la operación aritmética seleccionada.
     * Si no se ha establecido una operación previa, guarda el primer operando.
     * Si ya existe una operación, ejecuta la operación pendiente, muestra el resultado,
     * y actualiza el primer operando con dicho resultado.
     *
     * @param new_operacion el operador aritmético a ejecutar ("+", "-", "*", "/").
     */
    public void ejecutarOperador(String new_operacion) {

        int resultado;

        if (operacion.equals("null"))
        {
            resultado = getResultadoInt();
            valor1 = resultado;
        }

        else
        {
            valor2 = getResultadoInt();
            resultado = ejecutarOperacion();
            muestraResultado(resultado);
            valor1 = resultado;
        }

        inicializa_resultado = true;
        operacion = new_operacion;
    }

    /**
     * Ejecuta la operación pendiente (igual) y muestra el resultado en el display.
     */
    public void ejecutarIgual(){
        int resultado = 0;

        valor2 = getResultadoInt();
        resultado = ejecutarOperacion();
        muestraResultado(resultado);

        operacion = "null";
    }

    /**
     * Realiza el cálculo aritmético basado en el operador almacenado.
     *
     * @return el resultado de la operación.
     */
    public int ejecutarOperacion() {
        int resultado = 0;

        if (operacion.equals("/"))
        {

            if (valor2 == 0)
            {
                JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                operacion = "null";
                valor1 = 0;
                modo = MODE_ENTRADA;
                inicializa_resultado = true;
            }
            else
                resultado = valor1 / valor2;
        }

        if (operacion.equals("*"))
            resultado = valor1 * valor2;

        if (operacion.equals("-"))
            resultado = valor1 - valor2;

        if (operacion.equals("+"))
            resultado = valor1 + valor2;

        return resultado;
    }

    /**
     * Muestra el resultado de la operación en el display y actualiza el estado interno de la calculadora.
     *
     * @param resultado el valor a mostrar en el display.
     */
    public void muestraResultado(int resultado){
        setResultadoString(Integer.toString(resultado));
        valor1 = resultado;
        modo = MODE_RESULTADO;
        inicializa_resultado = true;
    }

    /**
     * Método principal que arranca la aplicación de la calculadora.
     *
     * @param args argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Calculadora calculadora = new Calculadora(true);
    }

}
