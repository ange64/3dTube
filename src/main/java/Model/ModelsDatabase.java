package Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.HashMap;

public abstract class ModelsDatabase {

    public static final  ModelBuilder builder = new ModelBuilder();
    public static final ModelLoader objLoader  = new ObjLoader();
    public static HashMap<String,Model> modelMap = new HashMap<>();

    static  {
        modelMap.put("ship", objLoader.loadModel(Gdx.files.internal("ship.obj")));
        modelMap.put("cube1", builder.createBox(.5f,.5f,.5f,
                new Material(ColorAttribute.createDiffuse(Color.RED)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));
    }

    public static  Model get(String modelPath){
        return modelMap.get(modelPath);
    }




    public static void disposeAll(){
        modelMap.values().forEach(Model::dispose);
    }

}
