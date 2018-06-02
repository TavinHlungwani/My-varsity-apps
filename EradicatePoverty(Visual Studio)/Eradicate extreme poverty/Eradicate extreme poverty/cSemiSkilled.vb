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

Public Class cSemiSkilled
    Inherits cUnemployedCitizens

    'Attributes
    Private _SemiSkill As String
    Private _SemiQualification As String

    'constructor
    Public Sub New(name As String, gender As String, age As Integer, experience As Double, workedHours As Double, SemiQualification As String)

        MyBase.New(name, gender, age, workedHours, experience)
        _SemiQualification = Qualification
    End Sub

    'Property methods
    Public Property Qualification As String
        Get
            Return _SemiQualification
        End Get

        Set(value As String)
            _SemiQualification = value
        End Set
    End Property

    Public Property Skill() As String
        Get
            Return _SemiSkill
        End Get

        Set(value As String)
            _SemiSkill = value
        End Set
    End Property

    'Methods
    Public Overrides Function CalculateSalary() As Double

        Return ((_workedHours * 30) * (_experience) ^ 2) * 0.75
    End Function

    Public Overrides Function Display() As String

        Return (vbCrLf & vbCrLf & "Category: Semi-skilled" & MyBase.Display() & vbCrLf & "Qualification: " & _SemiQualification & vbCrLf & "Salary: R" & CalculateSalary())
    End Function

End Class
