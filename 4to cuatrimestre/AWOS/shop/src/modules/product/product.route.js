const router = require('express').Router();
const { response } = require('express');
const productService = require('./product.service');

router.get('', async (request, response) => {
    response = await productService.findAll(response);
});

//findById
router.get('/:id', async(request, response) => {
    let {id} = request.params;
    response = await productService.findById(response, id);
});

//save
router.post('', async(request, response) => {
    const {name, description, id_category, id_brand} = request.body;
    let product = {name, description, id_category, id_brand};

    response = await productService.save(response, product);
});

//update
router.put('', async (request, response) => {
    let {id, name, description, id_category, id_brand} = request.body;
    let product = {id, name, description, id_category, id_brand};

    response = await productService.update(response, product);
})

//delete
router.delete('/:id', async (request, response) => {
    let {id} = request.params;
    response = await productService.remove(response, id);
});

module.exports = router;