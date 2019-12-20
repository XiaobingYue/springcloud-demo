function loadPersonOrgList() {
    $.get(path + '/personDep/list', function (data) {
        handleListData(data, 3);
    })
}

function savePersonOrg(type) {
    var data;
    if (type === 1){
        data = JSON.stringify(getFormData($('#personOrgForm')));
    } else {
        data = JSON.stringify(getFormData($('#personOrgForm1')))
    }
    $.ajax({
        type: 'post',
        url: path + '/personDep/add',
        contentType: 'application/json',
        dataType: 'json',
        data: data,
        success: function (data) {
            if (data.code === '1') {
                alert("保存成功");
                $('#bindDep').modal('hide');
                $('#bindPerson').modal('hide');
                $('#myTab a[href="#personOrg"]').tab('show');
                loadPersonOrgList();
            } else {
                alert("保存失败");
            }
        },
        error: function () {
            alert("保存失败");
        }
    })
}

function deletePersonDep(id) {
    $.get(path + '/personDep/delete?id=' + id, function (data) {
        if (data.code === '1') {
            alert("删除成功");
            loadPersonOrgList();
        } else {
            alert("删除失败");
        }
    })
}