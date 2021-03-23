using System;
using System.Windows.Forms;

namespace Calculadora
{
    public partial class Form1 : Form
    {
        private int primerNumero;
        private int segundoNumero;
        private string operador;
        
        private OperacionesCalculadora op;
        public Form1()
        {
            InitializeComponent();
            op = new OperacionesCalculadora();
        }

        private void btnUno_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnUno.Text);
        }

        private void btnDos_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnDos.Text);
        }

        private void btnTres_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnTres.Text);
        }

        private void btnCuatro_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnCuatro.Text);
        }

        private void btnCinco_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnCinco.Text);
        }

        private void btnSeis_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnSeis.Text);
        }

        private void btnSiete_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnSiete.Text);
        }

        private void btnOcho_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnOcho.Text);
        }

        private void btnNueve_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnNueve.Text);
        }

        private void btnCero_Click(object sender, EventArgs e)
        {
            txtResOP.Text = (txtResOP.Text + btnCero.Text);
        }

        private void btnSuma_Click(object sender, EventArgs e)
        {
            primerNumero = int.Parse(txtResOP.Text);
            operador = "+";
            txtResOP.Text = "";
        }

        private void btnResta_Click(object sender, EventArgs e)
        {
            primerNumero = int.Parse(txtResOP.Text);
            operador = "-";
            txtResOP.Text = "";
        }

        private void btnDivision_Click(object sender, EventArgs e)
        {
            primerNumero = int.Parse(txtResOP.Text);
            operador = "/";
            txtResOP.Text = "";
        }

        private void btnMultiplicacion_Click(object sender, EventArgs e)
        {
            primerNumero = int.Parse(txtResOP.Text);
            operador = "*";
            txtResOP.Text = "";
        }

        private void btnCuadrado_Click(object sender, EventArgs e)
        {
            primerNumero = int.Parse(txtResOP.Text);
            operador = "^";
            txtResOP.Text = "";
        }

        private void btnIgual_Click(object sender, EventArgs e)
        {
            segundoNumero = int.Parse(txtResOP.Text);
            txtResOP.Text = op.opResultado(operador, primerNumero, segundoNumero);
        }

        private void btnC_Click(object sender, EventArgs e)
        {
            txtResOP.Text = "";
        }

        private void txtResOP_TextChanged(object sender, EventArgs e)
        {
            txtResOP.MaxLength = 20;
            if (txtResOP.TextLength == 20)
            {
                txtResOP.Text = "Desbordamiento de Digitos";
                MessageBox.Show("Error Desbordamiento de Digitos",null,MessageBoxButtons.OK);
            }
        }
    }
}