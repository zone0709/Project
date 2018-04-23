<%-- 
    Document   : user
    Created on : Apr 21, 2018, 6:10:30 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<style>
    table{
        float:left;
        margin-left: 5px;
    }
    table td {
        text-align: center;
    }
    table tr {
        text-align: center;
    }
</style>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello <s:property value="#session.NAME"/></h1><br/>
        
        <s:if test="%{!#session.JaegerId.isEmpty()}">
            <h2><s:property value="%{#session.NAME}"/>'s Jaeger<br/><h2/>
                <s:iterator value="jaegerdetail"  status="counter">
                    <center>
                        <table border="1" >
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th colspan="2">Information</th>

                                </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <td rowspan="9"><img src="images/<s:property value="image"/>" height="500" width="350"/></td>
                                    <td>JaegerName</td>
                                    <td><s:property value="jaegername"/></td>
                                </tr>
                                <tr>
                                    <td>Height</td>
                                    <td><s:property value="height"/> m</td>
                                </tr>
                                <tr>
                                    <td>Weight</td>
                                    <td><s:property value="weight"/> tons</td>
                                </tr>
                                <tr>
                                    <td>Type</td>
                                    <td><s:property value="type"/></td>
                                </tr>
                                <tr>

                                    <td>Speed</td>
                                    <td><s:property value="speed"/></td>
                                </tr>
                                <tr>

                                    <td>Strength</td>
                                    <td><s:property value="strength"/></td>
                                </tr>
                                <tr>

                                    <td>Armor</td>
                                    <td><s:property value="armor"/></td>
                                </tr>
                                <tr>

                                    <td>Skill</td>
                                    <td>
                                        <input  id="ValueSkill" type="hidden" name="Test" value="" />
                                        <s:property value="Test"/>
                                    </td>
                                </tr>
                                <tr>

                                    <td>Weapon</td>
                                    <td>
                                        <select id="cbWeapon">
                                            <option value="-1">--Select--</option>
                                            <option value="Cannon">Cannon</option>
                                            <option value="Weight Sword">Weight Sword</option>
                                            <option value="Claw">Claw</option>
                                        </select>
                                    </td>
                                </tr>
                                
                            </tbody>
                        </table>
                    </center>
                </s:iterator>
            </s:if>
            <s:else>
                <h1>Choose Robot</h1>
                <s:iterator value="listjaeger"  status="counter">
                    <s:form action="SelectAction" method="POST" >
                        <table border="1" >

                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th colspan="2">Information</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td rowspan="6">
                                        <img src="images/<s:property value="image"/>" height="500" width="290"/>
                                    </td>
                                    <td>No.</td>
                                    <td><s:property value="%{#counter.count}"/></td>
                                </tr>
                                <tr>

                                    <td>JaegerName</td>
                                    <td><s:property value="jaegername"/></td>
                                </tr>
                                <tr>

                                    <td>Speed</td>
                                    <td><s:property value="Speed"/></td>
                                </tr>
                                <tr>

                                    <td>Strength</td>
                                    <td><s:property value="Strength"/></td>
                                </tr>
                                <tr>

                                    <td>Armor</td>
                                    <td><s:property value="Armor"/></td>
                                </tr>
                                <tr>

                                    <td>Type</td>
                                    <td><s:property value="Type"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="submit" value="Choose" style="width: 230px" /> </td>
                                    <td> <input type="radio" name="rdJager" value="<s:property value="jaegername"/>" </td>
                                </tr>
                            </tbody>

                        </table>
                    </s:form>
                </s:iterator>
            </s:else>
    </body>
</html>
<script type="text/javascript">
    $("#cbWeapon").change(function(){
        var option = $("#cbWeapon").val();
        if(option == "Cannon" ){
            ${"#ValueSkill"}.val() = option;
        }
    }){
        
    }
</script>