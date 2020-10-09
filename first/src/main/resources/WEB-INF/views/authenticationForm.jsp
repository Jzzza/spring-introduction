<html>
    <head><title>Login page</title></head>
    <body onload='document.f.j_username.focus();'>
        <h3>Login with Username and Password</h3.
        <form name='f' method='POST'
                action='/Spitter/j_spring_security_check'>
            <table>
                <tr><td>User:</td><td>
                    <input type='text' name='j_username' value=''>
                </td></tr>
                <tr><td colspan='2'>
                    <input name='submit' type='submit'/>
                </td></tr>
                <tr><td colspan='2'>
                    <input name='reset' type='reset' />
                </td></tr>
            </table>
        </form>
    </body>
</html>