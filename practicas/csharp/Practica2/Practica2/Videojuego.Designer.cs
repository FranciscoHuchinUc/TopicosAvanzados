namespace Practica2
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }

            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.paintContainer = new System.Windows.Forms.PictureBox();
            this.btnCirculo = new System.Windows.Forms.Button();
            this.btnCuadrado = new System.Windows.Forms.Button();
            this.btnArco = new System.Windows.Forms.Button();
            this.btnColor = new System.Windows.Forms.Button();
            this.btnTamanio = new System.Windows.Forms.Button();
            this.imgCirculo = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize) (this.paintContainer)).BeginInit();
            this.SuspendLayout();
            // 
            // paintContainer
            // 
            this.paintContainer.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.paintContainer.Location = new System.Drawing.Point(12, 107);
            this.paintContainer.Name = "paintContainer";
            this.paintContainer.Size = new System.Drawing.Size(652, 342);
            this.paintContainer.TabIndex = 0;
            this.paintContainer.TabStop = false;
            this.paintContainer.Click += new System.EventHandler(this.paintContainer_Click);
            this.paintContainer.Paint += new System.Windows.Forms.PaintEventHandler(this.paintContainer_Paint);
            this.paintContainer.MouseMove += new System.Windows.Forms.MouseEventHandler(this.paintContainer_MouseMove);
            // 
            // btnCirculo
            // 
            this.btnCirculo.Location = new System.Drawing.Point(26, 49);
            this.btnCirculo.Name = "btnCirculo";
            this.btnCirculo.Size = new System.Drawing.Size(75, 23);
            this.btnCirculo.TabIndex = 1;
            this.btnCirculo.Text = "Circulo(a)";
            this.btnCirculo.UseVisualStyleBackColor = true;
            this.btnCirculo.Click += new System.EventHandler(this.btnCirculo_Click);
            // 
            // btnCuadrado
            // 
            this.btnCuadrado.Location = new System.Drawing.Point(154, 49);
            this.btnCuadrado.Name = "btnCuadrado";
            this.btnCuadrado.Size = new System.Drawing.Size(75, 23);
            this.btnCuadrado.TabIndex = 2;
            this.btnCuadrado.Text = "Cuadrado (s)";
            this.btnCuadrado.UseVisualStyleBackColor = true;
            this.btnCuadrado.Click += new System.EventHandler(this.btnCuadrado_Click);
            // 
            // btnArco
            // 
            this.btnArco.Location = new System.Drawing.Point(292, 49);
            this.btnArco.Name = "btnArco";
            this.btnArco.Size = new System.Drawing.Size(75, 23);
            this.btnArco.TabIndex = 3;
            this.btnArco.Text = "Arco (d)";
            this.btnArco.UseVisualStyleBackColor = true;
            this.btnArco.Click += new System.EventHandler(this.btnArco_Click);
            // 
            // btnColor
            // 
            this.btnColor.Location = new System.Drawing.Point(427, 49);
            this.btnColor.Name = "btnColor";
            this.btnColor.Size = new System.Drawing.Size(75, 23);
            this.btnColor.TabIndex = 4;
            this.btnColor.Text = "Color (c)";
            this.btnColor.UseVisualStyleBackColor = true;
            this.btnColor.Click += new System.EventHandler(this.btnColor_Click);
            // 
            // btnTamanio
            // 
            this.btnTamanio.Location = new System.Drawing.Point(563, 49);
            this.btnTamanio.Name = "btnTamanio";
            this.btnTamanio.Size = new System.Drawing.Size(75, 23);
            this.btnTamanio.TabIndex = 5;
            this.btnTamanio.Text = "Tamaño (t)";
            this.btnTamanio.UseVisualStyleBackColor = true;
            this.btnTamanio.Click += new System.EventHandler(this.btnTamanio_Click);
            // 
            // imgCirculo
            // 
            this.imgCirculo.Image = ((System.Drawing.Image) (resources.GetObject("imgCirculo.Image")));
            this.imgCirculo.Location = new System.Drawing.Point(687, 139);
            this.imgCirculo.Name = "imgCirculo";
            this.imgCirculo.Size = new System.Drawing.Size(88, 63);
            this.imgCirculo.TabIndex = 6;
            // 
            // label1
            // 
            this.label1.Image = ((System.Drawing.Image) (resources.GetObject("label1.Image")));
            this.label1.Location = new System.Drawing.Point(690, 218);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(88, 49);
            this.label1.TabIndex = 7;
            // 
            // label2
            // 
            this.label2.Image = ((System.Drawing.Image) (resources.GetObject("label2.Image")));
            this.label2.Location = new System.Drawing.Point(690, 294);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(85, 40);
            this.label2.TabIndex = 8;
            // 
            // label3
            // 
            this.label3.Image = ((System.Drawing.Image) (resources.GetObject("label3.Image")));
            this.label3.Location = new System.Drawing.Point(687, 358);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(85, 47);
            this.label3.TabIndex = 9;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 461);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.imgCirculo);
            this.Controls.Add(this.btnTamanio);
            this.Controls.Add(this.btnColor);
            this.Controls.Add(this.btnArco);
            this.Controls.Add(this.btnCuadrado);
            this.Controls.Add(this.btnCirculo);
            this.Controls.Add(this.paintContainer);
            this.Name = "Form1";
            this.Text = "Videojuego";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Form1_KeyPress);
            ((System.ComponentModel.ISupportInitialize) (this.paintContainer)).EndInit();
            this.ResumeLayout(false);
        }

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;

        private System.Windows.Forms.Label imgCirculo;

        private System.Windows.Forms.Button btnTamanio;

        private System.Windows.Forms.Button btnCirculo;
        private System.Windows.Forms.Button btnCuadrado;
        private System.Windows.Forms.Button btnArco;
        private System.Windows.Forms.Button btnColor;
        private System.Windows.Forms.PictureBox paintContainer;

        #endregion
    }
}