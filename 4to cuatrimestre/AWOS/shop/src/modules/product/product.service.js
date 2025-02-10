const productRepo = require('./product.repo');
const customResponse = require('../../utils/custom.response');
const { response } = require('express');

const findAll = async (response) => {
    let list = await productRepo.findAll();
    return customResponse.getOK(response, 200, list);
}

//findById
const findById = async (response, id) => {
    try {
        let product = await productRepo.findById(id);
        return product
            ? customResponse.getOK(response, 200, product)
            : customResponse.get404(response);
    } catch (error) {
        console.log(error);
        return customResponse.get400(response);
    }
}

//save
const save = async (response, product) => {
    if (productRepo.save(product)){
        return customResponse.getOK(response, 201, undefined)
    }else{
        return customResponse.get404(response);
    }
}

//update
const update = async (response, product) => {
    let found = await productRepo.findById(product.id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await productRepo.update(product) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}

//delete
const remove = async (response, id) => {
    let found = await productRepo.findById(id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await productRepo.remove(id) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}


const productService = {
    findAll,
    findById, 
    save,
    update,
    remove
}

module.exports = productService;