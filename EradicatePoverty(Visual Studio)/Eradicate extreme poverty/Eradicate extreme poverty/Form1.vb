' ********************************************************************************* 
'  Team Number: Group 5
'  Team Member 1 Details: Gabela, TG (201400532)
'  Team Member 2 Details: Hlungwani, T (215021437) 
'  Team Member 3 Details: Chuene, AM (216077382) 
'  Team Member 4 Details: Taliwe, T (216009615) 
'  Practical:  P2016-09 
'  Class name: frmEEP
' *********************************************************************************

Option Strict On
Option Explicit On
Option Infer Off

Public Class frmEradicateExtremePoverty
    Private candidates() As cUnemployedCitizens
    Private nC As Integer

    Enum Unemployed

        SKILLED = 1
        SEMI_SKILLED = 2
        UNSKILLED = 3

    End Enum


    Private Sub btnNumCandidates_Click(sender As Object, e As EventArgs) Handles btnNumCandidates.Click
        nC = CInt(txtNumCandidates.Text)

        MsgBox("Setup Done. Press 'OK' to continue")

    End Sub

    Private Sub doPolymorphism()
        ReDim candidates(nC)
        Dim choice, age, highestGrade As Integer
        Dim experience As Double
        Dim fullName, gender, qualification As String

        For c As Integer = 1 To nC

            choice = CInt(InputBox("Please Select the category you belong to:" & vbCrLf &
                               "1) Skilled " & vbCrLf & "2) SemiSkilled " & vbCrLf & "3) UnSkilled "))

            fullName = InputBox("Please enter your full name")
            age = CInt(InputBox("Please enter your age"))
            experience = CInt(InputBox("Please enter you previous experience in working field?"))
            Dim gChoice As Integer
            gChoice = CInt(InputBox("Please select your gender:" & vbCrLf & "1) Male" & vbCrLf & "2) Female"))
            If gChoice = 1 Then gender = "Male"
            If gChoice = 2 Then gender = "Female"

            Select Case choice

                Case Unemployed.SKILLED
                    qualification = InputBox("Please enter your qualification")
                    Dim skilled As cSkilled = New cSkilled(fullName, gender, age, experience, qualification, 8)
                    skilled.fullName = fullName
                    skilled.age = age
                    skilled.gender = gender
                    skilled.qualification = qualification
                    skilled.experience = experience

                    candidates(c) = skilled
                    txtDisplay.Text &= candidates(c).Display()

                Case Unemployed.SEMI_SKILLED
                    qualification = InputBox("Please enter your qualification")
                    Dim semiSkilled As cSemiSkilled = New cSemiSkilled(fullName, gender, age, experience, 7, qualification)
                    semiSkilled.fullName = fullName
                    semiSkilled.age = age
                    semiSkilled.gender = gender
                    semiSkilled.Qualification = qualification
                    semiSkilled.experience = experience

                    candidates(c) = semiSkilled
                    txtDisplay.Text &= candidates(c).Display()

                Case Unemployed.UNSKILLED
                    Dim unSkilled As cUnSkilled = New cUnSkilled(fullName, gender, age, experience, 5)
                    highestGrade = CInt(InputBox("Please enter your highest grade"))
                    unSkilled.fullName = fullName
                    unSkilled.age = age
                    unSkilled.gender = gender
                    unSkilled.HighestGrade = highestGrade
                    unSkilled.experience = experience

                    candidates(c) = unSkilled
                    txtDisplay.Text &= candidates(c).Display()

            End Select

        Next c

    End Sub

    Private Sub Display(r As Integer, c As Integer, t As String)

        grdEradicateExtremePoverty.Row = r
        grdEradicateExtremePoverty.Col = c
        grdEradicateExtremePoverty.Text = t

    End Sub

    Private Sub btnShow_Click(sender As Object, e As EventArgs) Handles btnShow.Click
        Dim Num1 As Integer = 0
        Dim Num2 As Integer = 0
        Dim Num3 As Integer = 0


        For I As Integer = 1 To nC
            If (TypeOf candidates(I) Is cUnSkilled) Then
                Num1 += 1
            End If
            If (TypeOf candidates(I) Is cSkilled) Then
                Num2 += 1
            End If
            If (TypeOf candidates(I) Is cSemiSkilled) Then
                Num3 += 1
            End If
        Next I

        txtReg.Text &= CStr(Num1) & " People registered as Unskilled" & vbCrLf
        txtReg.Text &= CStr(Num2) & " People registered as Skilled" & vbCrLf
        txtReg.Text &= CStr(Num3) & " People registered as Semi-Skilled" & vbCrLf

        grdEradicateExtremePoverty.Rows = nC + 1
        Display(0, 1, "All ages")

        For c As Integer = 1 To nC
            Display(c, 0, "Person_" & CStr(c))
        Next c


        For i As Integer = 1 To nC

            If (TypeOf candidates(i) Is cSkilled) Then
                Dim skill As cSkilled
                skill = DirectCast(candidates(i), cSkilled)
                Display(i, 1, CStr(skill.age))
            End If
            If (TypeOf candidates(i) Is cSemiSkilled) Then
                Dim skill As cSemiSkilled
                skill = DirectCast(candidates(i), cSemiSkilled)
                Display(i, 1, CStr(skill.age))
            End If
            If (TypeOf candidates(i) Is cUnSkilled) Then
                Dim skill As cUnSkilled
                skill = DirectCast(candidates(i), cUnSkilled)
                Display(i, 1, CStr(skill.age))
            End If
        Next i

    End Sub


    Private Sub grdEradicateExtremePoverty_Load(sender As Object, e As EventArgs) Handles grdEradicateExtremePoverty.Load
        grdEradicateExtremePoverty.DebugState = True
    End Sub

    Private Sub btnCandidates_Click(sender As Object, e As EventArgs) Handles btnCandidates.Click
        doPolymorphism()
    End Sub

End Class
