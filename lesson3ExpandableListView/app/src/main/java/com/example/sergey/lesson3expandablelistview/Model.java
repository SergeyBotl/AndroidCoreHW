package com.example.sergey.lesson3expandablelistview;

public class Model {

    private long modelId;
    private String modelName;

    public Model(long modelId, String modelName) {
        this.modelId = modelId;
        this.modelName = modelName;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (modelId != model.modelId) return false;
        return modelName != null ? modelName.equals(model.modelName) : model.modelName == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (modelId ^ (modelId >>> 32));
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model" +modelName ;
    }
}
