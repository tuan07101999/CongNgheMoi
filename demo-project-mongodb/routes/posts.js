const express = require('express');
const router = express.Router();
const Post = require('../models/Post');

//GET ALL
router.get('/', async (req, res) => {
    try {
        const posts = await Post.find();
        res.json(posts);
    } catch (error) {
        res.json({message: error})
    }
});

//POST
router.post('/', async (req, res) =>{
    const post = new Post({
        title: req.body.title,
        description: req.body.description
    });

    try {
        const savedPost = await post.save();
        res.status(200).json(savedPost);
    } catch (err) {
        res.json({message: err});
        
    }
});

//SEPECIFIC POST
router.get('/:postId', async (req,res) => {
    try {
        const post = await Post.findById(req.params.postId);
        res.json(post);
    } catch (error) {
        res.json({message: error})
    }

})

//DELETE Post
router.delete('/:postId', async (req, res) => {
    try {
        const removedPost = await Post.remove({_id: req.params.postId})
        res.json(removedPost);
    } catch (error) {
        res.json({message: error})
    }
});

router.patch('/:postId', async (req,res) => {
    try {
        const updatedPost = await Post.updateOne(
            { _id: req.params.postId},
            { $set: {
                title: req.body.title,
                description: req.body.description
            }});
            res.json(updatedPost);
    } catch (error) {
    }
});

module.exports = router;