' ********************************************************************************* 
'  Team Number: Group 4
'  Team Member 1 Details: Gabela, TG (201400532)
'  Team Member 2 Details: Hlungwani, T (215021437) 
'  Team Member 3 Details: Chuene, AM (Student) 
'  Team Member 4 Details: Taliwe, T (216009615) 
'  Practical:  P2016-09 
'  Class name: frmEEP
' *********************************************************************************

Option Strict On
Option Explicit On
Option Infer Off

Public Class cUnSkilled
    Inherits cUnemployedCitizens

    'Attributes
    Private _HighestGrade As Integer

    'Constructor
    Public Sub New(name As String, gender As String, age As Integer, experience As Double, workedHours As Double)

        MyBase.New(name, gender, age, workedHours, experience)
    End Sub

    'Property methods
    Public Property HighestGrade() As Integer
        Get
            Return _HighestGrade
        End Get

        Set(value As Integer)
            If value < 1 Then value = 1
            If value > 12 Then value = 12
            _HighestGrade = Validate(value, 0)
        End Set

    End Property

    'Methods
    Public Overrides Function CalculateSalary() As Double

        Return ((_workedHours * 30) * (_experience))
    End Function

    Public Overrides Function Display() As String

        Return (vbCrLf & vbCrLf & "Category: Unskilled" & MyBase.Display() & vbCrLf & "Highest grade: " & _HighestGrade & vbCrLf & "Salary: R" & CalculateSalary())
    End Function

End Class
