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

Public Class cSkilled
    Inherits cUnemployedCitizens

    'Attributes
    Private _qualification As String
    Private _Skill As String

    'constructor
    Public Sub New(name As String, gender As String, age As Integer, experience As Double, qualification As String, workedHours As Double)
        MyBase.New(name, gender, age, experience, workedHours)

        _qualification = qualification
    End Sub

    'Property methods
    Public Property qualification() As String
        Get
            Return _qualification
        End Get

        Set(value As String)
            _qualification = value
        End Set
    End Property

    Public Property Skill() As String
        Get
            Return _Skill
        End Get

        Set(value As String)
            _Skill = value
        End Set
    End Property

    'Methods
    Public Overrides Function CalculateSalary() As Double

        Return ((_workedHours * 30) * (_experience) ^ 2)
    End Function

    Public Overrides Function Display() As String

        Return (vbCrLf & vbCrLf & "Category: Skilled " & MyBase.Display() & vbCrLf & "Qualification: " & _qualification & vbCrLf & "Salary: R" & CalculateSalary())
    End Function

End Class
