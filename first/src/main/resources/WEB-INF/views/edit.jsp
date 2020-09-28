<%@ taglib prefix="sf" uri="http://www.springframewok.org/tags/form" %>

<div>
<h2>Create a free Spitter account</h2>

<sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
    <fieldset>
    <table cellspacing="0">
        <tr>
            <th><label for="user_full_name">Full_name:</th>
            <td><sf:input path="fullName" size="15" maxlength="15" id="user_full_name"/><br/>
                <sf:errors path="fullName" cassClass="error"/>
            </td>
        </tr>
        <tr>
            <th><label for="user_screen_name">username:</label></th>
            <td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                <small id="username_msg">No spaces, please.</small><br/>
                <sf:errors path="username" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th><label for="password">Password:</label></th>
            <td><sf:password path="password" size="30"
                             showPassword="true"
                             id="password"/>
                <small>6 characters or more (be tricky!)</small><br/>
                <sf:errors path="password" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th><label for="email">Email Address:</label></th>
            <td><sf:input path="email" size="30" id="email"/>
                <small>In case you forget something</small>
                <sf:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <sf:checkbo path="updateByEmail" id="user_send_email_newslettter"/>
                <label for="updateByEmail">
                    Send me email updates!</label>
            </td>
        </tr>
        <tr>
            <th><label for="iamge">Profile image:</label></th>
            <td><inpute name="image" type="file"></td>
        </tr>
        <tr>
            <th></th>
            <td><input name="commit" type="submit" value="I accept. Create my account."></td>
        </tr>
    </table>
</fieldset>
</sf:form>
</div>