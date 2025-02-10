const URL = "http://localhost:8080";
let ownerList = [];
let typeList = [];
let pet = {};

const findAllOwners = async () => {
    await fetch(`${URL}/api/owner`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    }).then(response => response.json()).then(response => {
        console.log(response);
        ownerList = response.data;
    }).catch(console.log);
}

const findAllTypes = async () => {
    await fetch(`${URL}/api/type`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    }).then(response => response.json()).then(response => {
        console.log(response);
        typeList = response.data;
    }).catch(console.log);
}

const loadData = async () => {
    await findAllOwners();
    await findAllTypes();

    let ownerSelect = document.getElementById('ownerList');
    let typeSelect = document.getElementById('typeList');
    let content = '';
    ownerList.forEach(item => {
        content += `<option value="${item.id}">${item.fullname}</option>`;
    });
    ownerSelect.innerHTML = content;

    content = '';
    typeList.forEach(item => {
        content += `<option value="${item.id}">${item.name}</option>`;
    });
    typeSelect.innerHTML = content;
}

const savePet = async () => {
    pet = {
        nickname: document.getElementById('nickname').value,
        owner: {
            id: document.getElementById('ownerList').value
        },
        type: {
            id: document.getElementById('typeList').value
        }
    };

    await fetch(`${URL}/api/pet`, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, 
        body: JSON.stringify(pet)
    }).then(response => response.json()).then(response => {
        console.log(response);
        pet = {};
    }).catch(console.log);
}