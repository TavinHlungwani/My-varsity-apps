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

Public MustInherit Class cUnemployedCitizens

    'Attributes
    Protected _fullName As String
    Protected _gender As String
    Protected _age As Integer
    Protected _experience As Double
    Protected _workedHours As Double

    'Constructor 
    Public Sub New(_fullname As String, _Gender As String, _age As Integer, _experience As Double, _workedHours As Double)

        Me._fullName = _fullname
        Me._Gender = _Gender
        Me._age = _age
        Me._experience = _experience
        Me._workedHours = _workedHours

    End Sub

    'Property methods
    Public Property fullName() As String
        Get
            Return _fullName
        End Get
        Set(value As String)
            _fullName = value
        End Set

    End Property

    Public Property age() As Integer
        Get
            Return _age
        End Get

        Set(value As Integer)
            _age = Validate(value, 18)
        End Set
    End Property

    Public Property gender() As String
        Get
            Return _Gender
        End Get

        Set(value As String)
            _Gender = value
        End Set

    End Property

    Public Property experience() As Double
        Get
            Return _experience
        End Get

        Set(value As Double)
            _experience = Validate(value, 0)
        End Set
    End Property

    Public WriteOnly Property workedHours() As Double

        Set(value As Double)
            _workedHours = Validate(value, 0)
        End Set

    End Property

    'Methods
    Public MustOverride Function CalculateSalary() As Double

    Public Overridable Function Display() As String
        Dim Show As String
        Dim salary As Double = CalculateSalary()

        Show = vbCrLf & "Name: " & _fullName & vbCrLf &
                "Gender: " & _gender & vbCrLf &
                "Experience: " & _experience & " years"

        Return Show
    End Function

    'Helper/Utility Methods
    Protected Function Validate(Value As Integer, minimum As Integer) As Integer

        If (Value < minimum) Then
            Value = minimum
        End If
        Return Value
    End Function

    Protected Function Validate(Value As Double, minimum As Double) As Double

        If (Value < minimum) Then
            Value = minimum
        End If
        Return Value
    End Function


End Class
