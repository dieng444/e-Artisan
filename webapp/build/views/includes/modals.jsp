<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="logout-modal" class="ui small modal">
    <div class="ui icon header">
        <i class="power icon"></i>
        Voulez-vous vraiment vous déconnecter ?
    </div>
    <div class="actions ui grid container">
        <div class="ui black cancel button">
            <i class="remove icon"></i>
            Non
        </div>
        <div class="ui orange ok button">
            <i class="checkmark icon"></i>
            Oui
        </div>
    </div>
</div>
<c:if test="${!empty accessDenied}">
    <div id="admin-modal" class="ui small modal">
        <div class="ui icon header">
            <i class="minus circle icon"></i>
            Accès refusé. Vous n'êtes pas administrateur !
        </div>
        <div class="actions ui grid container">
            <div class="ui fluid black cancel button">
                <i class="remove icon"></i>
                OK
            </div>
        </div>
    </div>
</c:if>

