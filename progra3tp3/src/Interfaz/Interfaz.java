package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import Grafo.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;;
public class Interfaz {

	private JFrame frame;
	private JTextField textFieldCantNodos;
	private JTextField textFieldNombreVertice;
	private JTextField textFieldPrimerVertice;
	private JTextField textFieldSegundoVertice;
	private JTable tableMatriz;
	private Grafo grafo;
	private int cantNodos;
	private int contadorNodos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void mostrarMatriz(boolean matriz[][], int n) {
		DefaultTableModel model = (DefaultTableModel) tableMatriz.getModel();
		model.setRowCount(n);
		model.setColumnCount(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matriz[i][j] == false) {
					tableMatriz.setValueAt(0, i, j);
				} else {
					tableMatriz.setValueAt(1, i, j);
				}
			}
		}
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIngreseNodo = new JLabel("Ingrese cantidad de nodos:");
		lblIngreseNodo.setBounds(24, 21, 250, 14);
		frame.getContentPane().add(lblIngreseNodo);
		
		JLabel lblConfirmacionNodos = new JLabel("Listo \u2713");
		lblConfirmacionNodos.setForeground(Color.GREEN);
		lblConfirmacionNodos.setBounds(438, 21, 66, 14);
		frame.getContentPane().add(lblConfirmacionNodos);
		lblConfirmacionNodos.setVisible(false);
		
		textFieldCantNodos = new JTextField();
		textFieldCantNodos.setBounds(213, 18, 88, 20);
		frame.getContentPane().add(textFieldCantNodos);
		textFieldCantNodos.setColumns(10);
		
		JLabel lblNombreVertices = new JLabel("Ingrese nombre de vertice:");
		lblNombreVertices.setBounds(24, 58, 179, 14);
		frame.getContentPane().add(lblNombreVertices);
		
		JLabel lblFaltan = new JLabel("");
		lblFaltan.setBounds(496, 58, 46, 14);
		frame.getContentPane().add(lblFaltan);
		
		textFieldNombreVertice = new JTextField();
		textFieldNombreVertice.setBounds(213, 55, 88, 20);
		frame.getContentPane().add(textFieldNombreVertice);
		textFieldNombreVertice.setColumns(10);
		
		JButton btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantNodos = Integer.parseInt(textFieldCantNodos.getText());
				grafo = new Grafo(cantNodos);
				contadorNodos = cantNodos;

				textFieldCantNodos.setFocusable(false);
				textFieldCantNodos.setText("");
				btnListo.setEnabled(false);
				lblConfirmacionNodos.setVisible(true);
			}
		});
		btnListo.setBounds(326, 17, 89, 23);
		frame.getContentPane().add(btnListo);
		
		JButton btnAgregarVertice = new JButton("Agregar vertice");
		btnAgregarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafo.nuevoVertice(textFieldNombreVertice.getText());
				textFieldNombreVertice.setText("");
				contadorNodos--;
				lblFaltan.setText("Faltan " + contadorNodos);

				if (contadorNodos == 0) {
					lblFaltan.setText("Listo \u2713");
					lblFaltan.setForeground(Color.GREEN);
					textFieldNombreVertice.setFocusable(false);
					btnAgregarVertice.setEnabled(false);
				}
			}
		});
		btnAgregarVertice.setBounds(326, 54, 141, 23);
		frame.getContentPane().add(btnAgregarVertice);
		
		JLabel lblCrearArcos = new JLabel("Crear arcos:");
		lblCrearArcos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCrearArcos.setBounds(24, 94, 190, 20);
		frame.getContentPane().add(lblCrearArcos);
		
		JLabel lblPrimerVertice = new JLabel("Ingrese primer vertice:");
		lblPrimerVertice.setBounds(24, 125, 149, 14);
		frame.getContentPane().add(lblPrimerVertice);
		
		JLabel lblSegundoVertice = new JLabel("Ingrese segundo vertice:");
		lblSegundoVertice.setBounds(24, 162, 149, 14);
		frame.getContentPane().add(lblSegundoVertice);
		
		textFieldPrimerVertice = new JTextField();
		textFieldPrimerVertice.setBounds(213, 122, 86, 20);
		frame.getContentPane().add(textFieldPrimerVertice);
		textFieldPrimerVertice.setColumns(10);
		
		textFieldSegundoVertice = new JTextField();
		textFieldSegundoVertice.setBounds(215, 159, 86, 20);
		frame.getContentPane().add(textFieldSegundoVertice);
		textFieldSegundoVertice.setColumns(10);
		
		JButton btnCrearArco = new JButton("Crear arco");
		btnCrearArco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafo.nuevoArco(textFieldPrimerVertice.getText(), textFieldSegundoVertice.getText());
				textFieldPrimerVertice.setText("");
				textFieldSegundoVertice.setText("");
			}
		});
		
		tableMatriz = new JTable();
		tableMatriz.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tableMatriz.setBounds(24, 237, 639, 209);
		frame.getContentPane().add(tableMatriz);
		
		JLabel lblConjuntoDominante = new JLabel("");
		lblConjuntoDominante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConjuntoDominante.setBounds(311, 476, 350, 23);
		frame.getContentPane().add(lblConjuntoDominante);
		
		btnCrearArco.setBounds(346, 139, 156, 23);
		frame.getContentPane().add(btnCrearArco);
		
		JButton btnMostrarConjuntoDominante = new JButton("Mostrar conjunto dominante");
		btnMostrarConjuntoDominante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Vertice> conjunto = grafo.conjuntoDominante();
				lblConjuntoDominante.setText(conjunto.toString());
				textFieldPrimerVertice.setFocusable(false);
				textFieldSegundoVertice.setFocusable(false);
				btnCrearArco.setEnabled(false);
			}
		});
		btnMostrarConjuntoDominante.setBounds(24, 476, 250, 23);
		frame.getContentPane().add(btnMostrarConjuntoDominante);
		
		JLabel lblDosPuntos = new JLabel(":");
		lblDosPuntos.setBounds(290, 480, 46, 14);
		frame.getContentPane().add(lblDosPuntos);
		
		JButton btnNewButton = new JButton("Mostrar matriz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarMatriz(grafo.getMatAdyacencia(), cantNodos);
			}
		});
		btnNewButton.setBounds(24, 201, 139, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
