
using System;
using System.Drawing;
using System.Reflection;
using System.Windows.Forms;
using InputKey;

namespace Practica2
{
    public partial class Form1 : Form
    {
        private int x, y;
        private int w, h;
        private string isFigura;
        bool isClicked;
        private Color color;
        private Keys keyCode;
        public Form1()
        {
            InitializeComponent();
            x = y = 50;
            w = h = 100;
            color = Color.Blue;
            isClicked = false;
            ChangeControlStyles(btnCirculo,ControlStyles.Selectable, false);
            ChangeControlStyles(btnCuadrado,ControlStyles.Selectable, false);
            ChangeControlStyles(btnArco,ControlStyles.Selectable, false);
            ChangeControlStyles(btnColor,ControlStyles.Selectable, false);
            ChangeControlStyles(btnTamanio,ControlStyles.Selectable, false);
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MinimizeBox = false;
            this.MaximizeBox = false;
        }

        private void paintContainer_Paint(object sender, PaintEventArgs e)
        {
            SolidBrush brushColor = new SolidBrush(color);
            Pen penColor= new Pen(color, 6);
            Graphics g = e.Graphics;
            try
            {
                switch (isFigura)
                {
                    case "Circulo":
                        g.FillEllipse(brushColor, x, y, w, h);
                        break;
                    case "Cuadrado":
                        g.FillRectangle(brushColor, x, y, w, h);
                        break;
                    case "Arco":
                        Rectangle rect = new Rectangle(x, y, w, h);
                        g.DrawArc(penColor,rect,90, 60);
                        break;
                }
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
                throw;
            }
        }
        private void btnCirculo_Click(object sender, EventArgs e)
        {
            setIsFigura("Circulo");
            MessageBox.Show("Selecionado Circulo");
        }

        private void btnCuadrado_Click(object sender, EventArgs e)
        {
            setIsFigura("Cuadrado");
            MessageBox.Show("Selecionado Cuadrado");
        }

        private void btnArco_Click(object sender, EventArgs e)
        {
            setIsFigura("Arco");
            MessageBox.Show("Selecionado Arco");
        }

        private void btnColor_Click(object sender, EventArgs e)
        {
            string c = InputDialog.mostrar("Elija su Color Segun El Numero\n" +
                                        "0 - Black\n" +
                                        "1 - Blue\n" +
                                        "2 - Red\n" +
                                        "3 - Cyan\n"
                                        + "4 - Gray\n" +
                                        "5 - Green\n" +
                                        "6 - Yellow\n",
                "Selecione un Color");
            int ci = Convert.ToInt32(c);
            cambiarColor(ci);
            paintContainer.Invalidate();
        }

        private void btnTamanio_Click(object sender, EventArgs e)
        {
            try
            {
                string t = InputDialog.mostrar("Ingrese el Tamaño");
                int ti = Convert.ToInt32(t);
                setH(ti);
                setW(ti);
                paintContainer.Invalidate();
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
                throw;
            }
        }
        
        private void paintContainer_Click(object sender, EventArgs e)
        {
            setClicked();
            paintContainer.Invalidate();
        }
        
        private void paintContainer_MouseMove(object sender, MouseEventArgs e)
        {
            if (!getClicked())
            {
                setX(e.X);
                setY(e.Y);
                paintContainer.Invalidate();
            }
        }

        // Metodos
        public void cambiarColor(int c) {
            switch (c) {
                case 0:
                    setColor(Color.Black);
                    break;
                case 1:
                    setColor(Color.Blue);
                    break;
                case 2:
                    setColor(Color.Red);
                    break;
                case 3:
                    setColor(Color.Cyan);
                    break;
                case 4:
                    setColor(Color.Gray);
                    break;
                case 5:
                    setColor(Color.Green);
                    break;
                case 6:
                    setColor(Color.Yellow);
                    break;
                default:
                    setColor(Color.Blue);
                    break;
            }
        }
        
        private void ChangeControlStyles(Control ctrl, ControlStyles flag,  bool value)
        {
            MethodInfo method = ctrl.GetType().GetMethod("SetStyle", BindingFlags.Instance | BindingFlags.NonPublic);
            if (method != null)
                method.Invoke(ctrl, new object[] { flag, value });
        }
        
        // Getters and Setters
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
        public String getIsFigura() {
            return isFigura;
        }
        public void setIsFigura(String isFigura) {
            this.isFigura = isFigura;
        }
        public bool getClicked() {
            return isClicked;
        }
        public void setClicked() {
            this.isClicked = !this.isClicked;
        }
        public Color getColor() {
            return color;
        }
        public void setColor(Color color) {
            this.color = color;
        }
        // End of Getters and Setters
        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (getClicked())
            {
                switch (e.KeyChar.ToString())
                {
                    case "a": 
                    case "A":
                        btnCirculo.PerformClick();
                        Console.WriteLine(e.KeyChar.ToString());
                        break;
                    case "s":
                    case "S":
                        btnCuadrado.PerformClick();
                        Console.WriteLine(e.KeyChar.ToString());
                        break;
                    case "d":
                    case "D":
                        btnArco.PerformClick();
                        Console.WriteLine(e.KeyChar.ToString());
                        break;
                    case "c": 
                    case "C":
                        btnColor.PerformClick();
                        Console.WriteLine(e.KeyChar.ToString());
                        break;
                    case "t":
                    case "T":
                        btnTamanio.PerformClick();
                        Console.WriteLine(e.KeyChar.ToString());
                        break;
                }
            }
        }
    }
}