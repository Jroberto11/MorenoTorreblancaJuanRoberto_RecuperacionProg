package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import container.Contenedor;
import exeption.NoRellenadoException;
import models.Pokemon;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Pokedex {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textNumero;
	private JTextField textNivelEvo;
	private JTextField textRegion;
	private JTextField textComentarios;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnBuscar;
	private JButton btnInsertar;
	private JLabel lblNombre;
	private JLabel lblNumero;
	private JLabel lblNivelEvo;
	private JLabel lblComentarios;
	private JLabel lblTipo;
	private JLabel lblRegion;
	private JLabel lblPokedex;
	private JComboBox comboBox;
	private JButton btnGuardar;
	private JButton btnBuscar_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
		setComponetProperties();
		setComponetAdapters();
		modoEntrada();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		btnAnterior = new JButton("<");
		btnSiguiente = new JButton(">");
		textNombre = new JTextField();
		textNumero = new JTextField();
		textNivelEvo = new JTextField();
		textRegion = new JTextField();
		btnInsertar = new JButton("Insertar Nuevo Pok\u00E9mon");
		btnBuscar = new JButton("Buscar Pok\u00E9mon");
		lblNombre = new JLabel("Nombre");
		lblNumero = new JLabel("N\u00FAmero");
		lblNivelEvo = new JLabel("Nivel Evoluci\u00F3n");
		lblRegion = new JLabel("Regi\u00F3n");
		lblTipo = new JLabel("Tipo");
		textComentarios = new JTextField();
		lblComentarios = new JLabel("Comentarios");
		comboBox = new JComboBox();
		lblPokedex = new JLabel("POKEDEX");
		btnGuardar = new JButton("Guardar");
		btnBuscar_1 = new JButton("Buscar");


	}
	private void setComponetProperties(){

		frame.setBounds(100, 100, 666, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnAnterior.setBounds(30, 27, 92, 25);
		frame.getContentPane().add(btnAnterior);


		btnSiguiente.setBounds(531, 27, 92, 25);
		frame.getContentPane().add(btnSiguiente);

		textNombre.setBounds(167, 115, 116, 22);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textNumero.setBounds(167, 150, 116, 22);
		frame.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		textNivelEvo.setBounds(167, 185, 116, 22);
		frame.getContentPane().add(textNivelEvo);
		textNivelEvo.setColumns(10);

		textRegion.setBounds(167, 220, 116, 22);
		frame.getContentPane().add(textRegion);
		textRegion.setColumns(10);

		btnInsertar.setBounds(20, 314, 200, 25);
		frame.getContentPane().add(btnInsertar);

		btnBuscar.setBounds(253, 314, 200, 25);
		frame.getContentPane().add(btnBuscar);

		lblNombre.setBounds(82, 118, 56, 16);
		frame.getContentPane().add(lblNombre);

		lblNumero.setBounds(82, 153, 56, 16);
		frame.getContentPane().add(lblNumero);

		lblNivelEvo.setBounds(44, 188, 99, 16);
		frame.getContentPane().add(lblNivelEvo);

		lblRegion.setBounds(82, 223, 56, 16);
		frame.getContentPane().add(lblRegion);

		lblTipo.setBounds(338, 118, 56, 16);
		frame.getContentPane().add(lblTipo);

		textComentarios.setBounds(426, 173, 163, 128);
		frame.getContentPane().add(textComentarios);
		textComentarios.setColumns(10);

		lblComentarios.setBounds(320, 173, 74, 16);
		frame.getContentPane().add(lblComentarios);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fuego", "Agua", "Planta", "Tierra", "Roca", "Normal", "Bicho"}));
		comboBox.setBounds(426, 115, 151, 22);
		frame.getContentPane().add(comboBox);

		lblPokedex.setBounds(268, 29, 126, 20);
		frame.getContentPane().add(lblPokedex);


		btnGuardar.setBounds(167, 276, 97, 25);
		frame.getContentPane().add(btnGuardar);


		btnBuscar_1.setBounds(268, 62, 97, 25);
		frame.getContentPane().add(btnBuscar_1);
	}
	private void setComponetAdapters(){
		btnBuscar_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				modoBuscar();
				String nombre=textNombre.getText();
				if (!nombre.isEmpty()) {
					for (Pokemon c : Contenedor.ml) {
						if (c.getNombre().equals(nombre)) {
							textNombre.setEnabled(false);
							textComentarios.setText(c.getComentario());
							textNivelEvo.setText(c.getNivelEvo());
							textNumero.setText(c.getNumero());
							textRegion.setText(c.getRegion());
						}
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Revise el nombre introducido",
							"Error nombre incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				modoBuscar();
				modolimpiar();
			}
		});
		btnInsertar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				modoinsertar();
				modolimpiar();	

			}
		});

		btnGuardar.addMouseListener(new MouseAdapter() {
			boolean error=false;;
			@Override
			public void mousePressed(MouseEvent e) {
				String nombre = textNombre.getText();
				if (!nombre.isEmpty()) {
					for (Pokemon c : Contenedor.ml) {
						if (c.getNombre().equals(nombre)) {
							JOptionPane.showMessageDialog(frame, "El Pokemon ya se encuentra dentro de la pokedex.",
									"Error Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
							error=true;
							break;
						}
					}
					if(error==false){
						try{
							if(Contenedor.ml.add(nuevoPokemon())){
								JOptionPane.showMessageDialog(frame, "Pokemon introducido");
								modolimpiar();
							}
						}catch (NoRellenadoException e2) {
							new JOptionPane("Error").showMessageDialog(null, e2.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}	
					}else{
						JOptionPane.showMessageDialog(frame, "El Pokemon no se ha introducido","Error", JOptionPane.ERROR_MESSAGE);
				
					}
					


				} else {
					JOptionPane.showMessageDialog(frame, "Revise el nombre introducido",
							"Error Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
				}


			}
		});

	}
	private void modoinsertar(){
		btnGuardar.setVisible(true);
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		textNombre.setVisible(true);
		textNumero.setVisible(true);
		textNivelEvo.setVisible(true);
		textRegion.setVisible(true);
		btnInsertar.setVisible(true);
		btnBuscar.setVisible(true);
		lblNombre.setVisible(true);
		lblNumero.setVisible(true);
		lblNivelEvo.setVisible(true);
		lblRegion.setVisible(true);
		lblTipo.setVisible(true);
		textComentarios.setVisible(true);
		lblComentarios.setVisible(true);
		comboBox.setVisible(true);
		lblPokedex.setVisible(true);
		btnBuscar_1.setVisible(false);

		btnBuscar_1.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnInsertar.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		textNombre.setEnabled(true);
		textNumero.setEnabled(true);
		textNivelEvo.setEnabled(true);
		textRegion.setEnabled(true);
		btnInsertar.setEnabled(true);
		btnBuscar.setEnabled(true);
		textComentarios.setEnabled(true);
		comboBox.setEnabled(true);

	}
	private void modoEntrada(){
		btnGuardar.setVisible(false);
		btnAnterior.setVisible(true);
		btnSiguiente.setVisible(true);
		textNombre.setVisible(true);
		textNumero.setVisible(true);
		textNivelEvo.setVisible(true);
		textRegion.setVisible(true);
		btnInsertar.setVisible(true);
		btnBuscar.setVisible(true);
		lblNombre.setVisible(true);
		lblNumero.setVisible(true);
		lblNivelEvo.setVisible(true);
		lblRegion.setVisible(true);
		lblTipo.setVisible(true);
		textComentarios.setVisible(true);
		lblComentarios.setVisible(true);
		comboBox.setVisible(true);
		lblPokedex.setVisible(true);
		btnBuscar_1.setVisible(false);

		btnBuscar_1.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnInsertar.setEnabled(true);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		textNombre.setEnabled(false);
		textNumero.setEnabled(false);
		textNivelEvo.setEnabled(false);
		textRegion.setEnabled(false);
		btnBuscar.setEnabled(true);
		textComentarios.setEnabled(false);
		comboBox.setEnabled(false);
	}
	private void modoBuscar(){
		btnGuardar.setVisible(false);
		btnAnterior.setVisible(true);
		btnSiguiente.setVisible(true);
		textNombre.setVisible(true);
		textNumero.setVisible(true);
		textNivelEvo.setVisible(true);
		textRegion.setVisible(true);
		btnInsertar.setVisible(true);
		btnBuscar.setVisible(false);
		lblNombre.setVisible(true);
		lblNumero.setVisible(true);
		lblNivelEvo.setVisible(true);
		lblRegion.setVisible(true);
		lblTipo.setVisible(true);
		textComentarios.setVisible(true);
		lblComentarios.setVisible(true);
		comboBox.setVisible(true);
		lblPokedex.setVisible(true);
		btnBuscar_1.setVisible(true);

		btnBuscar_1.setEnabled(true);	
		btnGuardar.setEnabled(false);
		btnInsertar.setEnabled(true);
		btnAnterior.setEnabled(true);
		btnSiguiente.setEnabled(true);
		textNombre.setEnabled(true);
		textNumero.setEnabled(false);
		textNivelEvo.setEnabled(false);
		textRegion.setEnabled(false);
		btnBuscar.setEnabled(false);
		textComentarios.setEnabled(false);
		comboBox.setEnabled(false);

	}
	private void modolimpiar(){

		textNombre.setText("");
		textNumero.setText("");
		textNivelEvo.setText("");
		textRegion.setText("");
		textComentarios.setText("");
	}
	private Pokemon nuevoPokemon(){
		String nombre, numero, nivelEvo,region,tipo,comentario;
		tipo=(String) comboBox.getSelectedItem();

		// VALIDACION
		// Nombre
		if (!textNombre.getText().trim().isEmpty())
			nombre = textNombre.getText();
		else
			throw new NoRellenadoException("El campo 'Nombre' está vacío.");

		// Numero
		if (!textNumero.getText().trim().isEmpty())
			numero = textNumero.getText();
		else
			throw new NoRellenadoException("El campo 'Numero' está vacío.");

		// NivelEvo
		if (!textNivelEvo.getText().trim().isEmpty())
			nivelEvo = textNivelEvo.getText();
		else
			throw new NoRellenadoException("El campo 'Nivel evolucion' está vacío.");
		//región
		if (!textRegion.getText().trim().isEmpty())
			region = textRegion.getText();
		else
			throw new NoRellenadoException("El campo 'region' está vacío.");
		//comentarios
		if (!textComentarios.getText().trim().isEmpty())
			comentario = textComentarios.getText();
		else
			throw new NoRellenadoException("El campo 'Comentario' está vacío.");


		return new Pokemon(nombre, numero, nivelEvo,region,tipo,comentario);

	}
}
