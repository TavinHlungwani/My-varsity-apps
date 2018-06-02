<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmEradicateExtremePoverty
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btnNumCandidates = New System.Windows.Forms.Button()
        Me.btnShow = New System.Windows.Forms.Button()
        Me.txtNumCandidates = New System.Windows.Forms.TextBox()
        Me.lblNumCandidates = New System.Windows.Forms.Label()
        Me.txtDisplay = New System.Windows.Forms.TextBox()
        Me.btnCandidates = New System.Windows.Forms.Button()
        Me.grdEradicateExtremePoverty = New UJGrid.UJGrid()
        Me.txtReg = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'btnNumCandidates
        '
        Me.btnNumCandidates.Location = New System.Drawing.Point(154, 30)
        Me.btnNumCandidates.Name = "btnNumCandidates"
        Me.btnNumCandidates.Size = New System.Drawing.Size(103, 21)
        Me.btnNumCandidates.TabIndex = 17
        Me.btnNumCandidates.Text = "Initialize"
        Me.btnNumCandidates.UseVisualStyleBackColor = True
        '
        'btnShow
        '
        Me.btnShow.Location = New System.Drawing.Point(14, 220)
        Me.btnShow.Name = "btnShow"
        Me.btnShow.Size = New System.Drawing.Size(519, 24)
        Me.btnShow.TabIndex = 16
        Me.btnShow.Text = "Display Stats"
        Me.btnShow.UseVisualStyleBackColor = True
        '
        'txtNumCandidates
        '
        Me.txtNumCandidates.Location = New System.Drawing.Point(135, 8)
        Me.txtNumCandidates.Name = "txtNumCandidates"
        Me.txtNumCandidates.Size = New System.Drawing.Size(122, 20)
        Me.txtNumCandidates.TabIndex = 15
        '
        'lblNumCandidates
        '
        Me.lblNumCandidates.AutoSize = True
        Me.lblNumCandidates.Location = New System.Drawing.Point(11, 15)
        Me.lblNumCandidates.Name = "lblNumCandidates"
        Me.lblNumCandidates.Size = New System.Drawing.Size(118, 13)
        Me.lblNumCandidates.TabIndex = 14
        Me.lblNumCandidates.Text = "Number of Candidates :"
        '
        'txtDisplay
        '
        Me.txtDisplay.Location = New System.Drawing.Point(263, 8)
        Me.txtDisplay.Multiline = True
        Me.txtDisplay.Name = "txtDisplay"
        Me.txtDisplay.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.txtDisplay.Size = New System.Drawing.Size(272, 205)
        Me.txtDisplay.TabIndex = 12
        '
        'btnCandidates
        '
        Me.btnCandidates.Location = New System.Drawing.Point(135, 57)
        Me.btnCandidates.Name = "btnCandidates"
        Me.btnCandidates.Size = New System.Drawing.Size(122, 26)
        Me.btnCandidates.TabIndex = 11
        Me.btnCandidates.Text = "Select Category"
        Me.btnCandidates.TextAlign = System.Drawing.ContentAlignment.TopCenter
        Me.btnCandidates.UseVisualStyleBackColor = True
        '
        'grdEradicateExtremePoverty
        '
        Me.grdEradicateExtremePoverty.FixedCols = 1
        Me.grdEradicateExtremePoverty.FixedRows = 1
        Me.grdEradicateExtremePoverty.Location = New System.Drawing.Point(12, 250)
        Me.grdEradicateExtremePoverty.Name = "grdEradicateExtremePoverty"
        Me.grdEradicateExtremePoverty.Scrollbars = System.Windows.Forms.ScrollBars.Both
        Me.grdEradicateExtremePoverty.Size = New System.Drawing.Size(304, 175)
        Me.grdEradicateExtremePoverty.TabIndex = 18
        '
        'txtReg
        '
        Me.txtReg.Location = New System.Drawing.Point(338, 250)
        Me.txtReg.Multiline = True
        Me.txtReg.Name = "txtReg"
        Me.txtReg.Size = New System.Drawing.Size(197, 175)
        Me.txtReg.TabIndex = 19
        '
        'frmEradicateExtremePoverty
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(545, 438)
        Me.Controls.Add(Me.txtReg)
        Me.Controls.Add(Me.grdEradicateExtremePoverty)
        Me.Controls.Add(Me.btnNumCandidates)
        Me.Controls.Add(Me.btnShow)
        Me.Controls.Add(Me.txtNumCandidates)
        Me.Controls.Add(Me.lblNumCandidates)
        Me.Controls.Add(Me.txtDisplay)
        Me.Controls.Add(Me.btnCandidates)
        Me.Name = "frmEradicateExtremePoverty"
        Me.Text = "Eradicate Extreme Poverty"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnNumCandidates As Button
    Friend WithEvents btnShow As Button
    Friend WithEvents txtNumCandidates As TextBox
    Friend WithEvents lblNumCandidates As Label
    Friend WithEvents txtDisplay As TextBox
    Friend WithEvents btnCandidates As Button
    Friend WithEvents grdEradicateExtremePoverty As UJGrid.UJGrid
    Friend WithEvents txtReg As TextBox
End Class
