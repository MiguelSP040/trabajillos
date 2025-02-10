const URL = 'http://localhost:8080';
let ownerList = [];
let typeList = [];
let petList = [];
let pet = {};

const findAllPets = async () =>{
    await fetch (`${URL}/api/pet`,{
        method : 'GET',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        }
    }).then(response =>response.json()).then(response =>{
        //ToDo
        console.log(response);
        petList = response.data;
    }).catch(console.log());
}

const loadTable = async () => {
    await findAllPets();

    let tbody = document.getElementById("tbody");
    let content ='';
    petList.forEach((item, index)=>{
        content += `<tr>
                        <th scope="row">${index + 1}</th>
                        <td>${item.nickname}</td>
                        <td>${item.owner.fullname}</td>
                        <td>${item.type.name}</td>
                        <td class="text-center">
                            <button class="btn btn-outline-danger" onclick="findPetById(${item.id})" data-bs-target="#deleteModal" data-bs-toggle="modal">Eliminar</button>
                            <button class="btn btn-outline-primary" onclick="loadPet(${item.id})" data-bs-target="#updateModal" data-bs-toggle="modal">Editar</button>
                        </td>
                    </tr>`;
    });
    tbody.innerHTML = content;
}

(async () =>{
    await loadTable();
})();

const findAllOwners = async ()=>{
    await fetch (`${URL}/api/owner`,{
        method : 'GET',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        }
    }).then(response =>response.json()).then(response =>{
        //ToDo
        console.log(response);
        ownerList = response.data;
    }).catch(console.log());
}

const findAllTypes = async ()=>{
    await fetch (`${URL}/api/type`,{
        method : 'GET',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        }
    }).then(response =>response.json()).then(response =>{
        //ToDo
        console.log(response);
        typeList = response.data;
    }).catch(console.log());
}

const loadData = async () => {
    await findAllOwners();
    await findAllTypes();

    let ownerSelect = document.getElementById('ownerList');
    let typeSelect = document.getElementById('typeList');
    let content = '';

    if(ownerList.length === 0){
        content +=`<option selected disabled>No hay mascotas para adoptar</option>`
    }else{
        ownerList.forEach(item => {
            content +=`<option value="${item.id}">${item.fullname}</option>`
        });
    }
    

    ownerSelect.innerHTML = content;

    content = '';
    typeList.forEach(item =>{
        content +=`<option value="${item.id}">${item.name}</option>`
    });
    typeSelect.innerHTML = content ;
}

const findPetById = async id => {
    await fetch (`${URL}/api/pet/${id}`,{
        method : 'GET',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        }
    }).then(response =>response.json()).then(response =>{
        //ToDo
        console.log(response);
        pet = response.data;
    }).catch(console.log());
}

const loadPet = async id => {
    await findPetById(id);
    await findAllTypes();

    let select = document.getElementById("u_typeList");
    content = '';
    typeList.forEach(item =>{
        content +=`<option value="${item.id}">${item.name}</option>`
    });
    select.innerHTML = content ;

    document.getElementById("u_nickname").value = pet.nickname;
    document.getElementById("u_ownerList").value = pet.owner.fullname;
    select.value = pet.type.id;
}

const savePet = async () => {
    let form = document.getElementById('saveForm');
    let modal = new bootstrap.Modal(document.getElementById('saveModal'))
    pet={
        nickname : document.getElementById("nickname").value,
        owner : {
            id: document.getElementById('ownerList').value
        },
        type : {
            id: document.getElementById('typeList').value
        }
    };

    await fetch(`${URL}/api/petShop`, {
        method : 'POST',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        },
        body : JSON.stringify(pet)
    }).then(response => response.json()).then(async response => {
        console.log(response);
        pet = {};
        await loadTable();
        form.reset();
    }).catch(console.log);
}

const updatePet = async () => {
    let form = document.getElementById('updateForm');
    let updated = {
        nickname : document.getElementById("u_nickname").value,
        owner : pet.owner,
        type : {
            id: document.getElementById('u_typeList').value
        }
    };

    await fetch(`${URL}/api/pet/${pet.id}`, {
        method : 'PUT',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        },
        body : JSON.stringify(updated)
    }).then(response => response.json()).then(async response => {
        console.log(response);
        pet = {};
        await loadTable();
        form.reset();
    }).catch(console.log);
}

const deletePet = async () => {
    await fetch(`${URL}/api/pet/${pet.id}`, {
        method : 'DELETE',
        headers : {
            "Content-type" : "application/json",
            "Accept" : "application/json"
        },

    }).then(response => response.json()).then(async response => {
        console.log(response);
        pet = {};
        await loadTable();
    }).catch(console.log);
}