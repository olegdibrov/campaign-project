<html>
<body>

<style>
    form {
        margin:0 auto;
        width:300px
    }
    input {
        margin-bottom:3px;
        padding:10px;
        width: 100%;
        border:1px solid #CCC
    }
    button {
        padding:10px
    }
    label {
        cursor:pointer
    }
    #form-switch {
        display:none
    }
    #register-form {
        display:none
    }
    #form-switch:checked~#register-form {
        display:block
    }
    #form-switch:checked~#login-form {
        display:none
    }
</style>
<input type='checkbox' id='form-switch'>

<form id='login-form'  method="post" action="Servlet">
    <input type="email" placeholder="example@test.com" name="email" maxlength="40" required>
    <input type="password" placeholder="Password (maximum 40 character)" name="password" maxlength="40" required>
    <button type='submit' name="command" value="login">Login</button>
    <label for='form-switch'><span>Register</span></label>
</form>
<form id='register-form' method="post" action="Servlet">
    <input type="text" placeholder="Name: (maximum 40 character)" name="name" maxlength="40" required>
    <input type="text" placeholder="Surname: (maximum 40 character)" name="surname" maxlength="40" required>
    <input type="email" placeholder="example@test.com" name="email" maxlength="40" required>
    <input type="password" placeholder="Password (maximum 40 character)" name="password" maxlength="40" required>
    <button type='submit' name="command" value="registration">Register</button>
    <label for='form-switch'>Already Member ? Sign In Now..</label>
</form>

</body>
</html>
