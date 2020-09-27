<%@ taglib prefix="sf" uri="http://www.springframewok.org/tags/form" %>

<div>
<h2>Create a free Spitter account</h2>

<sf:form method="POST" modelAttribute="spitter">
    <fieldset>
    <table cellspacing="0">
        <tr>
            <th><label for="user_full_name">Full_name:</th>
            <td><sf:input path="fullName" size="15" maxlength="15" id="user_full_name"/></td>
        </tr>
        <tr>
            <th><label for="user_screen_name">username:</label></th>
            <td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                <small id="username_msg">No spaces, please.</small>
            </td>
        </tr>
        <tr>
            <th><label for="user_password">Password:</label></th>
            <td><sf:password path="password" size="30"
                             showPassword="true"
                             id="user_password"/>
                <small>6 characters or more (be tricky!)</small>
            </td>
        </tr>
        <tr>
            <th><label for="user_email">Email Address:</label></th>
            <td><sf:input path="email" size="30" id="user_email"/>
                <small>In case you forget something</small>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <sf:checkbo path="updateByEmail" id="user_send_email_newslettter"/>
                <label for="user_send_newsletter">
                    Send me email updates!</label>
            </td>
        </tr>
    </table>
</fieldset>
</sf:form>
</div>